package com.example.yatur.battle_academia

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_study.*

class StudyActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_study)

        val thispreference = MyPreference(this)

        applyBtn.setOnClickListener {
            addToHp(thispreference)
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }

    fun addToHp(preference: MyPreference) {
        preference.setHp(preference.getHp() + minutEt.text.toString().toInt())
    }

}
