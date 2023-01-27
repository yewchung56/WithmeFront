package com.oneg.maplocation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.oneg.maplocation.databinding.ActivityManageMyInfoBinding
import com.oneg.maplocation.databinding.ActivityModifyProfileBinding

class ModifyProfileActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityModifyProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityModifyProfileBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.btnModifyComplete.setOnClickListener {
            finish()
        }
    }
}