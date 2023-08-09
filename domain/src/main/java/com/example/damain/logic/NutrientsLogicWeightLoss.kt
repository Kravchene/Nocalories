package com.example.damain.logic

class NutrientsLogicWeightLoss {
    companion object{
    fun squirrelLogicLoss(calories: Int): Double {
        return calories * 0.3 / 4
    }

    fun logicFatsLoss(calories: Int): Double {
        return calories * 0.2 / 9
    }

    fun logicCarbohydratesLoss(calories: Int): Double {
        return calories * 0.5 / 4
    }

    fun logicFiberLoss(calories: Int): Int {
        return calories / 1000 * 14
    }
    }
}