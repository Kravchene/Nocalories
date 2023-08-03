package com.example.nocalories.ui.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.nocalories.databinding.FragmentLoginViaEmailBinding
import com.example.nocalories.ui.viewModel.AuthViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class Login_via_email : Fragment() {

    lateinit var binding: FragmentLoginViaEmailBinding
    private val authViewModel: AuthViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginViaEmailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            if ((loginEditText.text?.isEmpty() == true) || (passwordEditText.text?.isEmpty() == true)) {
                Toast.makeText(context, "Одно из полей пустое", Toast.LENGTH_SHORT).show()
            } else {
                buttonEntrance.setOnClickListener {
                    authViewModel.login(
                        loginEditText.text.toString(),
                        passwordEditText.text.toString()
                    )
                }
            }
        }
    }
}