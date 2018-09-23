package com.example.yatur.battle_academia

import android.app.Activity
import android.app.AlertDialog
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView

class BattleActivity : Activity() {

    private var todoList: ListView? = null
    private var addButton: Button? = null
    private var removeButton: Button? = null
    private var todoData: MutableList<String>? = null
    private var strengthData: MutableList<Int>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_battle)

        val thispreference = MyPreference(this)

        removeButton = findViewById(R.id.fightBtn)
        removeButton!!.setOnClickListener { removeData(thispreference) }

        init()
    }

    private fun init() {
        todoList = findViewById(R.id.bossLst)
        addButton = findViewById(R.id.bossBtn)
        todoData = ArrayList<String>()
        strengthData = ArrayList<Int>()

        addButton!!.setOnClickListener {
            addData2()
            addData()
        }
    }


    private fun addData() {
        val alert = AlertDialog.Builder(this)
        val edittext = EditText(this)
        alert.setTitle("Please Enter Boss Name")

        alert.setView(edittext)
        alert.setPositiveButton("Add") {dialog, whichButton ->
            val value = edittext.text.toString()
            todoData!!.add(value)
            setToDoListAdapter(todoData)
        }

        alert.setNegativeButton("Cancel") {dialog, whichButton ->
            // cancel dialog
        }

        alert.show()
    }

    private fun addData2() {
        val alert = AlertDialog.Builder(this)
        val edittext = EditText(this)
        alert.setTitle("Please Enter Strength")

        alert.setView(edittext)
        alert.setPositiveButton("Add") {dialog, whichButton ->
            val value = edittext.text.toString().toInt()
            strengthData!!.add(value)
        }

        alert.setNegativeButton("Cancel") {dialog, whichButton ->
            // cancel dialog
        }

        alert.show()
    }

    private fun removeData(preference: MyPreference) {
        val alert = AlertDialog.Builder(this)
        val edittext = EditText(this)
        alert.setTitle("Please Enter Boss Rank")

        alert.setView(edittext)
        alert.setPositiveButton("Add") {dialog, whichButton ->
            val value = edittext.text.toString().toInt()
            todoData!!.removeAt(value)
            val newHp = preference.getHp() - strengthData!![value]
            preference.setHp(newHp)
            strengthData!!.removeAt(value)
            winLoss(preference, newHp)
            setToDoListAdapter(todoData)
        }

        alert.setNegativeButton("Cancel") {dialog, whichButton ->
            // cancel dialog
        }

        alert.show()
    }

    private fun setToDoListAdapter(todoData: List<String>?) {
        // set up adapter for listView
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
        adapter.addAll(todoData)
        todoList!!.adapter = adapter
    }

    private fun winLoss(preference: MyPreference, hp: Int) {
        if (hp <= 0) {
            preference.setLs(preference.getLs() + 1)
        } else {
            preference.setWn(preference.getWn() + 1)
            preference.setGd(preference.getGd() + hp)
        }
    }
}
