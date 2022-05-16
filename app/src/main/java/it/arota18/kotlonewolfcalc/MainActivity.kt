package it.arota18.kotlonewolfcalc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity: TwoCounterActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}