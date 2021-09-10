package com.example.agiledo.ui

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.agiledo.R
import com.example.agiledo.data.DataManager
import com.example.agiledo.data.TaskDbHelper
import com.example.agiledo.data.domain.Task
import com.example.agiledo.databinding.ActivityHomeBinding
import com.example.agiledo.utils.Constants
import com.example.agiledo.utils.Date
import java.util.*
import java.security.cert.Certificate
import com.aghajari.emojiview.iosprovider.AXIOSEmojiProvider

import com.aghajari.emojiview.AXEmojiManager
import com.aghajari.emojiview.view.AXSingleEmojiView
import com.example.agiledo.databinding.EmojiDialogBinding
import com.example.agiledo.utils.Constants.dbHelper


class HomeActivity : AppCompatActivity(){
    //region initilize variables
    private val homeFragment = HomeFragment()
    private val statusFragment = StatusFragment()
    private val dateFragment= Date()
    lateinit var binding: ActivityHomeBinding
    //endregion

    //region onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Agiledo)
        setContentView(R.layout.activity_home)
        Constants.createTable(applicationContext)
        setup()
    }
    //endregion

    //region setup
    private fun setup() {
        addFragment(statusFragment)
        DataManager.readTask(dbHelper)
        AXEmojiManager.install(this,AXIOSEmojiProvider(this))



    }

    //endregion

    //region callbacks
    private fun addCallBacks() {
        //TODO ADD CALLBACKS
    }
    //endregion

    //region add fragments
    /**
     * add fragment to the home activity
     * @author Karrar Mohammed
     * @param Fragment the fragment you want to add to HomeActivity
     * @return nothing
     */
    private fun addFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container,fragment)
        transaction.commit()
    }

    /**
     * replace the existed fragment with the given fragment
     * @param Fragment the fragment you want to replace with the current fragment
     * @return nothing
     * @author Karrar Mohammed
     */
    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
    //endregion


}