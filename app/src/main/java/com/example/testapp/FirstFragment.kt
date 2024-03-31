package com.example.testapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.testapp.databinding.FragmentFirstBinding

class FirstFragment : AppCompatActivity() {

    private lateinit var return_btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_first)

        return_btn = findViewById(R.id.button_first)

        return_btn.setOnClickListener {
            // Launch SecondActivity
            //val intent = Intent(this, MainActivity::class.java)
            //startActivity(intent)
            val intent = Intent()
            val dataToReturn = 10
            intent.putExtra("data", dataToReturn)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}