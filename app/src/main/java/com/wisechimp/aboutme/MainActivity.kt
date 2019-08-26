package com.wisechimp.aboutme

import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        profile_nickname_butt.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {
        profile_nickname_tv.text = profile_nickname_edit_text.text
        profile_nickname_edit_text.visibility = View.GONE
        view.visibility = View.GONE
        profile_nickname_tv.visibility = View.VISIBLE

        //Hide the keyboard
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
