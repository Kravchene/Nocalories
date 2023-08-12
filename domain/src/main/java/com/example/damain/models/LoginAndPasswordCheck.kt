package com.example.damain.models

import java.util.regex.Pattern

class LoginAndPasswordCheck {
    companion object {
        fun checkEmail(string: String): Boolean {
            val hasUpperCase = Pattern.compile("[A-Z]").matcher(string).find()
            val hasDigit = Pattern.compile("[0-9]").matcher(string).find()
            val hasLowerCase = Pattern.compile("[a-z]").matcher(string).find()
            val hasSpecialCharacter = Pattern.compile("[!@#\$%^&*(),.?\":{}|<>]").matcher(string).find()
            return if (hasUpperCase && hasLowerCase && (hasDigit || hasSpecialCharacter) && string.length >= 10) {
                true
            } else {
                return false
            }

        }
        fun checkPassword(string: String): Boolean{
            val hasUpperCase = Pattern.compile("[A-Z]").matcher(string).find()
            val hasDigit = Pattern.compile("[0-9]").matcher(string).find()
            val hasLowerCase = Pattern.compile("[a-z]").matcher(string).find()
            val hasSpecialCharacter = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%!\\-_?&])(?=\\S+\$).{8,}").matcher(string).find()
            return if (hasUpperCase && hasLowerCase && (hasDigit || hasSpecialCharacter) && string.length >= 8) {
                true
            } else {
                return false
            }
        }
    }
}