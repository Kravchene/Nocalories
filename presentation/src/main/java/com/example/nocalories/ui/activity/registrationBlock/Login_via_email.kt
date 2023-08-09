package com.example.nocalories.ui.activity.registrationBlock

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.nocalories.R
import com.example.nocalories.databinding.FragmentLoginViaEmailBinding
import com.example.nocalories.ui.model.ValidateState
import com.example.nocalories.ui.viewModel.AuthViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.androidx.viewmodel.ext.android.viewModel


class Login_via_email : Fragment() {

    lateinit var binding: FragmentLoginViaEmailBinding
    private val authViewModel: AuthViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginViaEmailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
        initUi()
    }

    private fun initObservers() {
        authViewModel.state.observe(viewLifecycleOwner) { status ->
            with(binding) {
                when (status) {
                    ValidateState.SUCCESS -> {
                        val mProgressDialog = ProgressDialog(context)
                        mProgressDialog.setTitle("Вход")
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
                    findNavController().navigate(R.id.action_login_via_email_to_noCaloriesActivityNav)
                    requireActivity().finish()
                } else {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            context,
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
                if ((loginEditText.text?.isEmpty() == true) || (passwordEditText.text?.isEmpty() == true)) {
                    Toast.makeText(context, "Одно из полей пустое", Toast.LENGTH_SHORT).show()
                } else {
                    authViewModel.login(
                        loginEditText.text.toString(),
                        passwordEditText.text.toString()
                    )
                }
            }
        }
    }
}