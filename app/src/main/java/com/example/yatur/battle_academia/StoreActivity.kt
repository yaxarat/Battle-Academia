package com.example.yatur.battle_academia

import android.app.Activity
import android.app.AlertDialog
import android.os.Bundle
import android.widget.*

class StoreActivity : Activity() {

    private var todoList: ListView? = null
    private var addButton: Button? = null
    private var removeButton: Button? = null
    private var todoData: MutableList<String>? = null
    private var expenseData: MutableList<Int>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store)

        val thispreference = MyPreference(this)

        removeButton = findViewById(R.id.buyBtn)
        removeButton!!.setOnClickListener { removeData(thispreference) }

        init()
    }

    private fun init() {
        todoList = findViewById(R.id.storeLst)
        addButton = findViewById(R.id.addBtn)
        todoData = ArrayList<String>()
        expenseData = ArrayList<Int>()

        addButton!!.setOnClickListener {
            addData2()
            addData()
        }
    }


    private fun addData() {
        val alert = AlertDialog.Builder(this)
        val edittext = EditText(this)
        alert.setTitle("Please Enter Item Name")

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
        alert.setTitle("Please Enter Item Cost")

        alert.setView(edittext)
        alert.setPositiveButton("Add") {dialog, whichButton ->
            val value = edittext.text.toString().toInt()
            expenseData!!.add(value)
        }

        alert.setNegativeButton("Cancel") {dialog, whichButton ->
            // cancel dialog
        }

        alert.show()
    }

    private fun removeData(preference: MyPreference) {
        val alert = AlertDialog.Builder(this)
        val edittext = EditText(this)
        alert.setTitle("Please Enter Item Number")

        alert.setView(edittext)
        alert.setPositiveButton("Buy") {dialog, whichButton ->
            val value = edittext.text.toString().toInt()
            val newGd = preference.getGd() - expenseData!![value]
            winLoss(preference, newGd, value)
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

    private fun winLoss(preference: MyPreference, newGd: Int, value: Int) {
        if (newGd <= 0) {
            Toast.makeText(this, "You can't afford it! You only have " + preference.getGd().toString(), Toast.LENGTH_SHORT).show()
        } else {
            todoData!!.removeAt(value)
            preference.setGd(newGd)
            expenseData!!.removeAt(value)
            setToDoListAdapter(todoData)
        }
    }
}
