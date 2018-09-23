package com.example.yatur.battle_academia

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_hero.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Button navigation to other activities
        heroBtn.setOnClickListener {
            val intent = Intent(applicationContext, HeroActivity::class.java)
            startActivity(intent)
        }
        battleBtn.setOnClickListener {
            val intent = Intent(applicationContext, BattleActivity::class.java)
            startActivity(intent)
        }
        storeBtn.setOnClickListener {
            val intent = Intent(applicationContext, StoreActivity::class.java)
            startActivity(intent)
        }
    }
}
