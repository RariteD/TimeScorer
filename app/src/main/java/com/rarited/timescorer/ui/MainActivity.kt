package com.rarited.timescorer.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.rarited.timescorer.R
import com.rarited.timescorer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var b: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        val view = b.root
        setContentView(view)

//        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
//        val adapter = TimerListAdapter()
//        recyclerView.adapter = adapter
//        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onStart() {
        super.onStart()
        supportFragmentManager.beginTransaction()
            .replace(R.id.dataContainer, SWListFragment()).commit()
        b.addNewSw.setOnClickListener {
            Toast.makeText(
                this,
                "Haha Jonathan, You Are Banging My Daughter! :)",
                Toast.LENGTH_SHORT
            ).show()
            SWNewDialog().show(supportFragmentManager, "New")
        }

    }

}