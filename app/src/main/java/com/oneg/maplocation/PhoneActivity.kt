package com.oneg.maplocation

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_phone.*
import java.util.jar.Manifest

class PhoneActivity(private var inputTextPhone : Any, private var sendSMSBtn:Any) : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone)

        inputTextPhone = findViewById(R.id.input_text_phone)
        sendSMSBtn = findViewById(R.id.send_sms_btn)
    }

    private var permissionCheck = ContextCompat.checkSelfPermission(this, android.Manifest.permission.SEND_SMS)


}