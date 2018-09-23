package com.example.yatur.battle_academia

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_hero.*

class HeroActivity : Activity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hero)

        val thispreference = MyPreference(this)
        getAll(thispreference)

        // Button navigation to other activities
        studyBtn.setOnClickListener {
            val intent = Intent(applicationContext, StudyActivity::class.java)
            startActivity(intent)
        }
    }

    fun getAll(preference: MyPreference) {
        healthTv.text = preference.getHp().toString()
        goldTv.text = preference.getGd().toString()
        winTv.text = preference.getWn().toString()
        lossTv.text = preference.getLs().toString()
    }
}
