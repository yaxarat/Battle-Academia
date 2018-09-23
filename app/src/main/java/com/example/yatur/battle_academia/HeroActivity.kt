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
        getHp(thispreference)

        // Button navigation to other activities
        studyBtn.setOnClickListener {
            val intent = Intent(applicationContext, StudyActivity::class.java)
            startActivity(intent)
        }
    }

    fun getHp(preference: MyPreference) {
        healthTv.text = preference.getHp().toString()
    }
}
