package com.example.damain.models

import java.util.regex.Pattern
const val REGEX_EMAIL="^([A-Za-z0-9_\\-\\.])+\\@([A-Za-z0-9_\\-\\.])+\\.([A-Za-z]{2,8})$"
const val REGEX_PASSWORD="^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[#\\?!$%^&\\-_=;:\\+\\.,<>\\{\\}\\[\\]\\|\\(\\)\\/\\*\\\\])[a-zA-Z\\d#\\?!$%^&\\-_=;:\\+\\.,<>\\{\\}\\[\\]\\|\\(\\)\\/\\*\\\\]{8,255}$"
class LoginAndPasswordCheck {
    companion object {
        fun checkEmail(string: String): Boolean {
            return REGEX_EMAIL.toRegex().matches(string)
        }
        fun checkPassword(string: String): Boolean{
            return REGEX_PASSWORD.toRegex().matches(string)
        }
    }
}