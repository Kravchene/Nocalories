package com.example.damain.logic

class TheLogicOfCountingCalories {
    companion object {
        fun maintainingWeight(gender: Int, year: Int, weight: Double, height: Int): Int {
            return if (gender == 0) {
                val value: Double = 66.5 + (13.75 * weight) + (5.003 * height) + (6.775 * year)
                value.toInt()
            } else {
                val value: Double = 655.1 + (9.563 * weight) + (1.85 * height) + (4.676 * year)
                value.toInt()
            }
        }

        fun logicForWeightLoss(gender: Int, year: Int, weight: Double, height: Int): Int {
            return if (gender == 0) {
                val value: Double =
                    66.5 + (13.75 * weight) + (5.003 * height) + (6.775 * year) - 400
                value.toInt()
            } else {
                val value: Double =
                    655.1 + (9.563 * weight) + (1.85 * height) + (4.676 * year) - 400
                value.toInt()
            }
        }

        fun logicForWeightGain(gender: Int, year: Int, weight: Double, height: Int): Int {
            return if (gender == 0) {
                val value: Double =
                    66.5 + (13.75 * weight) + (5.003 * height) + (6.775 * year) + 500
                value.toInt()
            } else {
                val value: Double =
                    655.1 + (9.563 * weight) + (1.85 * height) + (4.676 * year) + 500
                value.toInt()
            }
        }
    }
}