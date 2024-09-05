package com.example.motivacao.ui

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.motivacao.MotivationConstants
import com.example.motivacao.R
import com.example.motivacao.SecurityPreferences
import com.example.motivacao.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Hide taskbar
        //supportActionBar!!?.hide()

        //Events
        binding.buttonNewPharse.setOnClickListener(this)

        //Show user_name
        handleUserName()
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_new_pharse){
            var s = "ENTROU"
        }
    }

    private fun handleUserName(){
        val name = SecurityPreferences(this).getPreferences(MotivationConstants.KEY.USER_NAME)
        binding.userName.text = "Olá, $name!"
    }
}