package com.example.yatur.battle_academia

import android.content.Context

class MyPreference(context: Context) {

    val PREFERENCE_NAME = "Name"
    val PREFERENCE_HP = "HP"
    val PREFERENCE_GD = "GD"
    val PREFERENCE_WN = "WN"
    val PREFERENCE_LS = "LS"

    val preference = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)

    fun getHp() : Int{
        return preference.getInt(PREFERENCE_HP, 0)
    }

    fun setHp(hp: Int) {
        val editor = preference.edit()
        editor.putInt(PREFERENCE_HP, hp)
        editor.apply()
    }

    fun getGd() : Int{
        return preference.getInt(PREFERENCE_GD, 0)
    }

    fun setGd(gd: Int) {
        val editor = preference.edit()
        editor.putInt(PREFERENCE_GD, gd)
        editor.apply()
    }

    fun getWn() : Int{
        return preference.getInt(PREFERENCE_WN, 0)
    }

    fun setWn(wn: Int) {
        val editor = preference.edit()
        editor.putInt(PREFERENCE_WN, wn)
        editor.apply()
    }

    fun getLs() : Int{
        return preference.getInt(PREFERENCE_LS, 0)
    }

    fun setLs(ls: Int) {
        val editor = preference.edit()
        editor.putInt(PREFERENCE_LS, ls)
        editor.apply()
    }
}