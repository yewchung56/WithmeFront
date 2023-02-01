package com.example.withme

import android.app.Application
import com.kakao.sdk.common.KakaoSdk

class GlobalApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        KakaoSdk.init(this, "bf1f958399e8542520d6388d9ba66de9")
    }
}