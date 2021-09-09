package com.example.agiledo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.agiledo.R
import com.example.agiledo.data.DataManager
import com.example.agiledo.data.TaskDbHelper
import com.example.agiledo.data.domain.Task
import com.example.agiledo.databinding.ActivityHomeBinding
import com.example.agiledo.utils.Constants
import java.util.*

class HomeActivity : AppCompatActivity(){
    //region initilize variables
    private val homeFragment = HomeFragment()
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
        addFragment(homeFragment)
        DataManager.readTask(Constants.dbHelper)

    }
    //endregion

    //region callbacks
    private fun addCallBacks() {

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