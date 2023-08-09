package com.example.damain.logic

class NutrientsLogicMaintainingWeight {
    companion object {


        fun squirrelLogic(calories: Int): Double {
            return calories * 0.3 / 4
        }

        fun logicFats(calories: Int): Double {
            return calories * 0.3 / 9
        }

        fun logicCarbohydrates(calories: Int): Double {
            return calories * 0.4 / 4
        }

        fun logicFiber(calories: Int): Int {
            return calories / 1000 * 14
        }
    }
}