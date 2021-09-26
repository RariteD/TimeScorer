package com.rarited.timescorer.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.rarited.timescorer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var b: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        val view = b.root
        setContentView(view)
    }

    override fun onStart() {
        super.onStart()
        supportFragmentManager.beginTransaction()
            .replace(b.dataContainer.id, SWListFragment()).commit()
        b.addNewSw.setOnClickListener {
            Toast.makeText(
                this,
                "Opened",
                Toast.LENGTH_SHORT
            ).show()
            SWNewDialog().show(supportFragmentManager, "New")
        }

    }

}