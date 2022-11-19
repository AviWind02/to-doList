package com.example.assignment3

import android.annotation.SuppressLint
import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    var itemsListed = mutableListOf<listData>(listData("Test", "TEST", false))
    lateinit var addItemFAB: FloatingActionButton
    lateinit var g_Adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        g_Adapter = Adapter(itemsListed)
        val recyclerView: RecyclerView = findViewById(R.id.First_Recycler_View)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = g_Adapter

        addItemFAB = findViewById(R.id.add_TV_Show_FAB)

        addItemFAB.setOnClickListener{
            showCreateTVShowDialog()
        }
    }

    private fun showCreateTVShowDialog() {
        val dialogTitle = getString(R.string.dialog_title)
        val positiveButtonTitle = getString(R.string.add_tv_show)
        val builder = AlertDialog.Builder(this)
        val view = layoutInflater.inflate(R.layout.add_list_item, null)

        builder.setTitle(dialogTitle)
        builder.setView(view)

        builder.setPositiveButton(positiveButtonTitle) { dialog, _ ->
            dialog.dismiss()
            val itemTitle = view.findViewById<EditText>(R.id.item_title_new)
            val itemBody = view.findViewById<EditText>(R.id.item_body_new)
            val newTVShow = listData(itemTitle.text.toString(), itemBody.text.toString(), false);
            itemsListed.add(newTVShow)
            g_Adapter.notifyItemInserted(itemsListed.size)
        }
        builder.create().show()
    }

}