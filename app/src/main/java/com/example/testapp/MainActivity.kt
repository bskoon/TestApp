package com.example.testapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.testapp.databinding.ActivityMainBinding
import android.widget.TextView
import android.view.MotionEvent
import android.widget.Button


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    private var count = 0
    public var money = 1
    private lateinit var mainText: TextView
    private lateinit var countTextView: TextView
    private lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainText = findViewById(R.id.countTextView)
        countTextView = findViewById(R.id.counter)
        btn = findViewById(R.id.button)

        btn.setOnClickListener {
            // Launch SecondActivity
            val intent = Intent(this, FirstFragment::class.java)
            startActivityForResult(intent, 1)
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            count+=money
            countTextView.text = "Count: $count"
        }
        return super.onTouchEvent(event)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            var receivedData = data?.getIntExtra("data", 0)
            // Do something with the received data
            if (receivedData != null) {
                mainText.text = "Successfully got data"
                money += receivedData
            }
            else {
                mainText.text = "Fail to got data"
            }
        }
    }
}