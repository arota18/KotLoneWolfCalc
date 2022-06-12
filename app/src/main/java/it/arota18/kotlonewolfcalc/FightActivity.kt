package it.arota18.kotlonewolfcalc

import android.os.Bundle
import android.view.View
import android.widget.TextView
import it.arota18.kotlonewolfcalc.utils.Constants
import it.arota18.kotlonewolfcalc.utils.LWUtils

class FightActivity : TwoCounterActivity() {

    var lwEndurance: Int = -999
    var lwCombat: Int = -999
    var enEndurance: Int = -999

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fight)
        etEndurance = findViewById(R.id.txtEnemyEndurance)
        etCombat = findViewById(R.id.txtEnemyCombat)
        val extras = intent.extras
        if (extras != null) {
            lwEndurance = extras.getInt(Constants.EXT_ENDURANCE)
            lwCombat = extras.getInt(Constants.EXT_COMBAT)
        }
    }

    // buttons handlings

    fun subEnemyEndurance(v: View?) {
        editTxtValue(1)
    }

    fun addEnemyEndurance(v: View?) {
        editTxtValue(2)
    }

    fun subEnemyCombat(v: View?) {
        editTxtValue(3)
    }

    fun addEnemyCombat(v: View?) {
        editTxtValue(4)
    }

    fun startFight(v: View?) {
        var enEndurance = -1
        var enCombat = -1
        try {
            enEndurance = etEndurance!!.text.toString().toInt()
            enCombat = etCombat!!.text.toString().toInt()
            this.enEndurance = enEndurance
            findViewById<TextView>(R.id.textView3).text = fullCombat(lwCombat - enCombat)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun fullCombat(combatRatio: Int): String? {
        val ccr: Int = LWUtils.convertCombatRatio(combatRatio)
        var result = ""
        var i = 0
        do {
            i++
            val rollValue: Int = LWUtils.roll()
            result += "($rollValue)"
            val lwDmg: Int = LWUtils.decodeDmg[rollValue][ccr][1]
            lwEndurance.minus(lwDmg)
            val enDmg: Int = LWUtils.decodeDmg[rollValue][ccr][0]
            enEndurance.minus(enDmg)
            result += enEndurance
        } while (lwEndurance > 0 && enEndurance > 0)
        return "$result lw end:$lwEndurance r:$i"
    }
}