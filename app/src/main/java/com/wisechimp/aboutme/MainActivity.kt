package com.wisechimp.aboutme

import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.wisechimp.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var userName: ProfileData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        userName = ProfileData(getString(R.string.subjects_name), "", getString(R.string.profile_text))
        binding.userName = userName

        binding.profileNicknameButt.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {
        binding.apply {
            userName?.nickname = profile_nickname_edit_text.text.toString()
            invalidateAll()
            profile_nickname_edit_text.visibility = View.GONE
            view.visibility = View.GONE
            profile_nickname_tv.visibility = View.VISIBLE
        }

        //Hide the keyboard
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
