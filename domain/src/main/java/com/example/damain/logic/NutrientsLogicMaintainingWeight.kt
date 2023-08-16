package com.example.damain.logic

import kotlin.math.roundToInt

class NutrientsLogicMaintainingWeight {
    companion object {


        fun squirrelLogic(calories: Int): Double {
            return (calories * 0.3 / 4).roundToInt().toDouble()
        }

        fun logicFats(calories: Int): Double {
            return (calories * 0.3 / 9).roundToInt().toDouble()
        }

        fun logicCarbohydrates(calories: Int): Double {
            return (calories * 0.4 / 4).roundToInt().toDouble()
        }

        fun logicFiber(calories: Int): Int {
            return calories / 1000 * 14
        }
    }
}