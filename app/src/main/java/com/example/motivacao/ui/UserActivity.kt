package com.example.motivacao.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.motivacao.MotivationConstants
import com.example.motivacao.R
import com.example.motivacao.SecurityPreferences
import com.example.motivacao.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSave.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_save){
            handleSave()
        }
    }

    private fun verifyUserName(){
        val userName = SecurityPreferences(this).getPreferences(MotivationConstants.KEY.USER_NAME)
        if (userName != ""){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    fun handleSave() {
        val userName = binding.editName.text.toString()

        if (userName != ""){
            SecurityPreferences(this).setPreferences(MotivationConstants.KEY.USER_NAME, userName)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        } else {
            Toast.makeText(this, R.string.validate_mandatory_name, Toast.LENGTH_SHORT).show()
        }
    }
}