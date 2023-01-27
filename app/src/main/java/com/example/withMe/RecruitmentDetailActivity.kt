package com.example.withMe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

class RecruitmentDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recruitment_detail)
        val toolbar = findViewById<Toolbar>(R.id.recruitment_detail_toolbar)
        setSupportActionBar(toolbar)
        val actionbar = supportActionBar!!
        actionbar.setDisplayShowTitleEnabled(false)
        actionbar.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_back)


    }
    fun onCheckboxClicked(view: View) {
        if(view is CheckBox){
            val checked: Boolean = view.isChecked

            when(view.id){
                R.id.recruitment_detail_heart->{
                    if(checked){
                        //
                    }
                    else{
                        //
                    }
                }
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when(id){
            android.R.id.home ->{
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }


}