package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityMainBinding
    private val myName:MyName =MyName("piyush")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.myName = myName
//        findViewById<Button>(R.id.button).setOnClickListener {
//            updateNickname(it)
//        }
        binding.button.setOnClickListener {
            updateNickname(it)
        }
    }
    private fun updateNickname(view:View){

//        val editText = binding.nickNameEdit
//        val nickNameTextView = binding.nicknameTextview
//        val button_update = binding.button
//        val editText = findViewById<EditText>(R.id.nickName_Edit)
//        val nickNameTextView = findViewById<TextView>(R.id.nickname_textview)
//        val button_update = findViewById<Button>(R.id.button)
        binding.apply {
           myName?.nickname = nickNameEdit.text.toString()
            invalidateAll()
            nickNameEdit.visibility = View.GONE
            nicknameTextview.visibility = View.VISIBLE
            button.visibility = View.GONE
        }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)



    }
}