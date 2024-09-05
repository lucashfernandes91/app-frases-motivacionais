package com.example.motivacao

import android.content.Context
import android.content.SharedPreferences

class SecurityPreferences (context: Context){
    private val security: SharedPreferences =
        context.getSharedPreferences("Motivation", Context.MODE_PRIVATE)

    fun setPreferences(key: String, name: String){
        security.edit().putString(key, name).apply()
    }

    fun getPreferences(key: String): String{
        return security.getString(key, "") ?: ""
    }
}