package com.example.nocalories.ui.activity.registrationBlock

import android.app.ProgressDialog
import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.damain.models.User
import com.example.nocalories.R
import com.example.nocalories.databinding.FragmentRegistrationStage1Binding
import com.example.nocalories.ui.model.ValidateState
import com.example.nocalories.ui.viewModel.AuthViewModel
import com.example.nocalories.ui.viewModel.UserMetricsViewModel
import com.example.nocalories.ui.viewModel.UserViewModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.pawegio.kandroid.defaultSharedPreferences
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.androidx.viewmodel.ext.android.viewModel


class RegistrationUser : Fragment() {
    lateinit var binding: FragmentRegistrationStage1Binding
    lateinit var dataFirebase: DatabaseReference
    private val authViewModel: AuthViewModel by viewModel()
    private val userViewModel: UserViewModel by viewModel()
    private val userMetricsViewModel: UserMetricsViewModel by viewModel()
    val scope = CoroutineScope(Dispatchers.IO)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationStage1Binding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataFirebase = FirebaseDatabase.getInstance().getReference("User")

        val autoCompleteTextView: AutoCompleteTextView = binding.autoCompleteTextView

        val goal = resources.getStringArray((R.array.Goal))
        val arrayAdapter = context?.let { ArrayAdapter(it, R.layout.dropdown_item, goal) }
        autoCompleteTextView.setAdapter(arrayAdapter)
        val mSpannableString = SpannableString(resources.getText(R.string.user_agreement2))
        mSpannableString.setSpan(UnderlineSpan(), 0, mSpannableString.length, 0)
        binding.userAgreement.text = mSpannableString
        initUi()
        initObservers()

    }

    private fun initObservers() {
        authViewModel.state.observe(viewLifecycleOwner) { status ->
            with(binding) {
                when (status) {
                    ValidateState.SUCCESS -> {
                        val mProgressDialog = ProgressDialog(context)
                        mProgressDialog.setTitle("Регистрация")
                        mProgressDialog.setMessage("Пожалуйста подождите")
                        mProgressDialog.show()
                    }

                    ValidateState.FAIL -> {
                        Toast.makeText(context, "Проверьте данные!", Toast.LENGTH_SHORT).show()
                    }

                    ValidateState.DEFAULT -> {}
                }
            }
        }
        lifecycleScope.launch {
            authViewModel.authState.collectLatest { status ->
                if (status.isSuccess) {
                    scope.launch {
                        saveUser(user())
                    }
                    lifecycleScope.launch {
                        userMetricsViewModel.insertUserMetrics(
                            caloriesDay = 0,
                            activityDay = 0,
                            waterDay = 0.0,
                            squirrelsDay = 0.0,
                            carbohydratesDay = 0.0,
                            fatsDay = 0.0,
                            fiberDay = 0.0
                        )
                    }
                    saveUserData()
                    val prefs = requireActivity().defaultSharedPreferences
                    prefs.edit {
                        putBoolean("CHECK", true)
                    }
                    findNavController().navigate(R.id.action_registration_Stage_1_to_noCaloriesActivityNav)
                    requireActivity().finish()
                } else {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            activity,
                            "Network Error: ${status.error}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }

    private fun initUi() {
        with(binding) {
            buttonEntrance.setOnClickListener {
                if (loginEditText.text?.isEmpty() == true && passwordEditText.text?.isEmpty() == true && passwordEditText2.text?.isEmpty() == true &&
                    YearEditText.text?.isEmpty() == true && weightEditText.text?.isEmpty() == true && HeightEditText.text?.isEmpty() == true
                ) {
                    Toast.makeText(context, "Одно из полей пустое", Toast.LENGTH_SHORT).show()
                } else {

                    authViewModel.signUp(
                        loginEditText.text.toString(),
                        passwordEditText.text.toString()
                    )
                }
            }
        }
    }

    private fun saveUserData() {
        val userId = dataFirebase.push().key!!
        val userModel = user()
        dataFirebase.child(userId).setValue(userModel).addOnCanceledListener {
            Toast.makeText(context, "Данные сохранены", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener {
            Toast.makeText(context, "Ошибка", Toast.LENGTH_SHORT).show()
        }

    }

    private fun user(): User {
        with(binding) {
            val name = loginEditText.text.toString()
            val gender: Int = when (radio.checkedRadioButtonId) {
                R.id.radio1 -> 0
                R.id.radio2 -> 1
                else -> 0
            }
            val goal: Int = when (autoCompleteTextView.adapter.toString()) {
                "Быть в форме" -> 0
                "Похудеть" -> 1
                "Набрать мышечную массу" -> 2
                else -> 2
            }
            val year = YearEditText.text.toString().toInt()
            val weight = weightEditText.text.toString().toDouble()
            val height = HeightEditText.text.toString().toInt()

            return User(name, gender, goal, year, weight, height)
        }
    }

    suspend fun saveUser(user: User) {
        lifecycleScope.launch {
            userViewModel.insertUser(
                name = user.name,
                gender = user.gender,
                goal = user.goal,
                age = user.age,
                height = user.height,
                weight = user.weight
            )
        }
    }
}