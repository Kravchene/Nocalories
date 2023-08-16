package com.example.damain.logic

class LogicWater {
    companion object{
        fun waterFine(weight: Double):Double{
            return weight*30/1000
        }
        fun waterForWeightLoss(weight: Double):Double{
            return weight*40/1000
        }
    }
}