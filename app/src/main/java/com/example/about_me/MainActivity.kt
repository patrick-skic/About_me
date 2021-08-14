package com.example.about_me

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.example.about_me.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        //findViewById<Button>(R.id.Done_button).setOnClickListener{
           // addNickname(it)}
        binding.DoneButton.setOnClickListener {
            addNickname(it)
        }
    }
    private fun addNickname(view:View){
        binding.apply{
            nicknameText.text=binding.nicknameEdit.text
            invalidateAll()
            nicknameEdit.visibility= View.GONE
            DoneButton.visibility=View.GONE
            nicknameText.visibility=View.VISIBLE
        }

//HIDE THE KEYBOARD
        val imm=getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }
}