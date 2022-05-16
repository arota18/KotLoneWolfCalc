package it.arota18.kotlonewolfcalc

import kotlin.math.floor
import kotlin.math.roundToInt

class LWUtils {
    /**
     * public method used for random number with default min=0 and max=9
     *
     * @return random int between 0 and 9
     */
    fun roll(): Int {
        return roll(1, 10) - 1
    }

    /**
     * public method used for random number with custom limit as params
     *
     * @param min lower limit
     * @param max upper limit
     * @return random int between given limit
     */
    fun roll(min: Int, max: Int): Int {
        return floor(min + Math.random() * (max - min + 1)).toInt()
    }

    /**
     * public method used to convert combat ratio for decodeDmg Y value
     *
     * @param cr actual combat ratio
     * @return converted combat ratio
     */
    fun convertCombatRatio(cr: Int): Int {
        return 6 + if (cr < 0)
            floor(cr.toDouble() / 2).toInt().coerceAtLeast(-6)
        else
            (cr.toFloat() / 2).roundToInt().coerceAtMost(6)
    }

    /**
     * static final matrix filled with the official combat result table value (LW1°book)
     * [x][y][z]
     * x = d10 roll value
     * y = converted combat ratio
     * z = 0 enemy, 1 lone wolf
     */
    val decodeDmg: Array<Array<IntArray>> = arrayOf( // TODO: check if this type is correct
        // 0
        arrayOf(
            intArrayOf(6, 0),
            intArrayOf(7, 0),
            intArrayOf(8, 0),
            intArrayOf(9, 0),
            intArrayOf(10, 0),
            intArrayOf(11, 0),
            intArrayOf(12, 0),
            intArrayOf(14, 0),
            intArrayOf(16, 0),
            intArrayOf(18, 0),
            intArrayOf(999, 0),
            intArrayOf(999, 0),
            intArrayOf(999, 0)
        ),
        // 1
        arrayOf(
            intArrayOf(0, 999),
            intArrayOf(0, 999),
            intArrayOf(0, 8),
            intArrayOf(0, 6),
            intArrayOf(1, 6),
            intArrayOf(2, 5),
            intArrayOf(3, 5),
            intArrayOf(4, 5),
            intArrayOf(5, 4),
            intArrayOf(6, 4),
            intArrayOf(7, 4),
            intArrayOf(8, 3),
            intArrayOf(9, 3)
        ),
        // 2
        arrayOf(
            intArrayOf(0, 999),
            intArrayOf(0, 8),
            intArrayOf(0, 7),
            intArrayOf(1, 6),
            intArrayOf(2, 5),
            intArrayOf(3, 5),
            intArrayOf(4, 4),
            intArrayOf(5, 4),
            intArrayOf(6, 3),
            intArrayOf(7, 3),
            intArrayOf(8, 3),
            intArrayOf(9, 3),
            intArrayOf(10, 2)
        ),
        // 3
        arrayOf(
            intArrayOf(0, 8),
            intArrayOf(0, 7),
            intArrayOf(1, 6),
            intArrayOf(2, 5),
            intArrayOf(3, 5),
            intArrayOf(4, 4),
            intArrayOf(5, 4),
            intArrayOf(6, 3),
            intArrayOf(7, 3),
            intArrayOf(8, 3),
            intArrayOf(9, 2),
            intArrayOf(10, 2),
            intArrayOf(11, 2)
        ),
        // 4
        arrayOf(
            intArrayOf(0, 8),
            intArrayOf(1, 7),
            intArrayOf(2, 6),
            intArrayOf(3, 5),
            intArrayOf(4, 4),
            intArrayOf(5, 4),
            intArrayOf(6, 3),
            intArrayOf(7, 3),
            intArrayOf(8, 2),
            intArrayOf(9, 2),
            intArrayOf(10, 2),
            intArrayOf(11, 2),
            intArrayOf(12, 2)
        ),
        // 5
        arrayOf(
            intArrayOf(1, 7),
            intArrayOf(2, 6),
            intArrayOf(3, 5),
            intArrayOf(4, 4),
            intArrayOf(5, 4),
            intArrayOf(6, 3),
            intArrayOf(7, 2),
            intArrayOf(8, 2),
            intArrayOf(9, 2),
            intArrayOf(10, 2),
            intArrayOf(11, 2),
            intArrayOf(12, 2),
            intArrayOf(14, 1)
        ),
        // 6
        arrayOf(
            intArrayOf(2, 6),
            intArrayOf(3, 6),
            intArrayOf(4, 5),
            intArrayOf(5, 4),
            intArrayOf(6, 3),
            intArrayOf(7, 2),
            intArrayOf(8, 2),
            intArrayOf(9, 2),
            intArrayOf(10, 2),
            intArrayOf(11, 1),
            intArrayOf(12, 1),
            intArrayOf(14, 1),
            intArrayOf(16, 1)
        ),
        // 7
        arrayOf(
            intArrayOf(3, 5),
            intArrayOf(4, 5),
            intArrayOf(5, 4),
            intArrayOf(6, 3),
            intArrayOf(7, 2),
            intArrayOf(8, 2),
            intArrayOf(9, 1),
            intArrayOf(10, 1),
            intArrayOf(11, 1),
            intArrayOf(12, 0),
            intArrayOf(14, 0),
            intArrayOf(16, 0),
            intArrayOf(18, 0)
        ),
        // 8
        arrayOf(
            intArrayOf(4, 4),
            intArrayOf(5, 4),
            intArrayOf(6, 3),
            intArrayOf(7, 2),
            intArrayOf(8, 1),
            intArrayOf(9, 1),
            intArrayOf(10, 0),
            intArrayOf(11, 0),
            intArrayOf(12, 0),
            intArrayOf(14, 0),
            intArrayOf(16, 0),
            intArrayOf(18, 0),
            intArrayOf(999, 0)
        ),
        // 9
        arrayOf(
            intArrayOf(5, 3),
            intArrayOf(6, 3),
            intArrayOf(7, 2),
            intArrayOf(8, 0),
            intArrayOf(9, 0),
            intArrayOf(10, 0),
            intArrayOf(11, 0),
            intArrayOf(12, 0),
            intArrayOf(14, 0),
            intArrayOf(16, 0),
            intArrayOf(18, 0),
            intArrayOf(999, 0),
            intArrayOf(999, 0)
        )
    )
}