package com.example.nocalories.ui.activity

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.nocalories.R
import com.example.nocalories.databinding.FragmentRegistrationStage1Binding
import com.example.nocalories.ui.model.ValidateState
import com.example.nocalories.ui.viewModel.AuthViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.androidx.viewmodel.ext.android.viewModel


class Registration_Stage_1 : Fragment() {
    lateinit var binding: FragmentRegistrationStage1Binding
    private val authViewModel: AuthViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationStage1Binding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val autoCompleteTextView: AutoCompleteTextView = binding.autoCompleteTextView

        val goal = resources.getStringArray((R.array.Goal))
        val arrayAdapter = context?.let { ArrayAdapter(it, R.layout.dropdown_item, goal) }
        autoCompleteTextView.setAdapter(arrayAdapter)
        val mSpannableString = SpannableString(resources.getText(R.string.user_agreement2))
        mSpannableString.setSpan(UnderlineSpan(), 0, mSpannableString.length, 0)
        binding.userAgreement.text=mSpannableString
        initUi()
        initObservers()
    }

    private fun initObservers() {
        authViewModel.state.observe(viewLifecycleOwner) { status ->
            with(binding) {
                when(status) {
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
                    findNavController().navigate(R.id.action_registration_Stage_1_to_noCaloriesActivity)
                } else {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(context, "Network Error: ${status.error}", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun initUi() {
        with(binding) {
            if (loginEditText.text?.isEmpty()  == true && passwordEditText.text?.isEmpty()  == true&& passwordEditText2.text?.isEmpty() == true &&
                YearEditText.text?.isEmpty() == true && weightEditText.text?.isEmpty() == true && HeightEditText.text?.isEmpty() == true
            ) {
                Toast.makeText(context, "Одно из полей пустое", Toast.LENGTH_SHORT).show()
            } else {
                buttonEntrance.setOnClickListener {
                    authViewModel.signUp(
                        loginEditText.text.toString(),
                        passwordEditText.text.toString(),
                        when (radio.checkedRadioButtonId) {
                            R.id.radio1 -> 0
                            else -> {
                                1
                            }
                        },
                        when (autoCompleteTextView.toString()) {
                            "Быть в форме" -> 0
                            "Похудеть" -> 1
                            else -> {
                                2
                            }
                        },
                        YearEditText.text.toString().toShort(),
                        weightEditText.text.toString().toShort(),
                        HeightEditText.text.toString().toShort()
                    )

                }
            }
        }
    }
}