package com.example.intentintetfilters

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.intentintetfilters.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.buttonLoadUrl.setOnClickListener {
            val url = binding.etToGetUrl.text.toString()
            val urlIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(urlIntent)
        }

        binding.btToSendData.setOnClickListener {
            val data = binding.etToGetUrl.text.toString()
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("data", data)
            startActivity(intent)
        }

        binding.buttonDial.setOnClickListener {
            val number = binding.etToGetUrl.text.toString()
            val intent = Intent(Intent.ACTION_DIAL,Uri.parse("tel:$number"))
            startActivity(intent)

        }

    }
}