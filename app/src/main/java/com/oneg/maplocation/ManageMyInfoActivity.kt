package com.oneg.maplocation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.oneg.maplocation.databinding.ActivityManageMyInfoBinding

class ManageMyInfoActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityManageMyInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityManageMyInfoBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        // 프로필 수정하기 버튼 클릭 시 화면 전환 -> ModifyProfileActivity
        viewBinding.btnManageModifyProfile.setOnClickListener {
            val intent = Intent(this, ModifyProfileActivity::class.java)
            startActivity(intent)
        }
    }
}