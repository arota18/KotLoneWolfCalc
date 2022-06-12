package it.arota18.kotlonewolfcalc

import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

open class TwoCounterActivity : AppCompatActivity() {
    /**
     * view ref.
     */
    protected var etEndurance: EditText? = null

    /**
     * view ref.
     */
    protected var etCombat: EditText? = null

    /**
     * protected method used to increase/decrease endurance and combat counter
     *
     * @param mode int value that represent which button has been pressed
     */
    protected fun editTxtValue(mode: Int) {
        var `val` = -1
        val et: EditText? = if (mode < 3) etEndurance else etCombat
        try {
            `val` = et!!.text.toString().toInt()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        if (mode % 2 == 0)
            if (`val` == -1) `val` = 1
            else `val`++
        else if (`val` > 0) `val`--
        if (`val` != -1) et!!.setText(`val`.toString())
    }
}