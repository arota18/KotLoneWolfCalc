package it.arota18.kotlonewolfcalc

import android.content.Intent
import android.os.Bundle
import android.view.View
import it.arota18.kotlonewolfcalc.utils.Constants

class MainActivity : TwoCounterActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etEndurance = findViewById(R.id.txtEndurance)
        etCombat = findViewById(R.id.txtCombat)
        // TODO:
        val extras = intent.extras
        if (extras != null) {
            etEndurance!!.setText(extras.getString(Constants.EXT_ENDURANCE))
            etEndurance!!.setText(extras.getString(Constants.EXT_COMBAT))
        }
    }

    // buttons handling

    fun toFight(v: View?) {
        try {
            val intent = Intent(this, FightActivity::class.java)
            intent.putExtra(Constants.EXT_ENDURANCE, etEndurance!!.text.toString().toInt())
            intent.putExtra(Constants.EXT_COMBAT, etCombat!!.text.toString().toInt())
            startActivity(intent)
        } catch (e: Exception) {
            // TODO: add error message, popup?
        }
    }

    fun subEndurance(v: View?) {
        editTxtValue(1)
    }

    fun addEndurance(v: View?) {
        editTxtValue(2)
    }

    fun subCombat(v: View?) {
        editTxtValue(3)
    }

    fun addCombat(v: View?) {
        editTxtValue(4)
    }
}