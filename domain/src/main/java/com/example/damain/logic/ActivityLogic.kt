package com.example.damain.logic

class ActivityLogic {
    companion object {
        fun activityLogic(number: Int, min: Int): Int {
            return when (number) {
                1 -> {
                    min * 10
                }

                2 -> {
                    min * 12
                }

                3 -> {
                    min * 11
                }

                4 -> {
                    min * 6
                }

                5 -> {
                    min * 6
                }

                6 -> {
                    min * 5
                }

                7 -> {
                    min * 7
                }

                8 -> {
                    min * 13
                }

                9 -> {
                    min * 7
                }

                10 -> {
                    min * 13
                }

                11 -> {
                    min * 7
                }

                12 -> {
                    min * 8
                }

                13 -> {
                    min * 9
                }

                14 -> {
                    min * 3
                }

                15 -> {
                    min * 5
                }

                else -> {
                    min * 7
                }

            }
        }
    }
}