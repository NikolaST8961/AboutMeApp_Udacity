package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputBinding
import android.view.inputmethod.InputMethod
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName = MyName("Alex Cooper")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.myName = myName

        //findViewById<Button>(R.id.done_button).setOnClickListener{
        //    addNickname(it)
        //}
        binding.doneButton.setOnClickListener{
            addNickname(it)
        }
    }
    private fun addNickname(view:View){
        binding.apply {
            //nicknameText.text = NickNameEdit.text
            myName?.nickname = NickNameEdit.text.toString()
            invalidateAll()
            NickNameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            NickNameEdit.visibility = View.VISIBLE
        }


        //Hide the keyboard
        val imn = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imn.hideSoftInputFromWindow(view.windowToken, 0)
    }
}