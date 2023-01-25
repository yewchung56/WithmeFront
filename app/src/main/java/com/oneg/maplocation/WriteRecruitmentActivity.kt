package com.oneg.maplocation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.oneg.maplocation.databinding.ActivityWriteRecruitmentBinding

class WriteRecruitmentActivity : AppCompatActivity() {

    lateinit var viewBinding: ActivityWriteRecruitmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityWriteRecruitmentBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val items_category = resources.getStringArray(R.array.spinner_category)
        val items_region = resources.getStringArray(R.array.spinner_region)
        val items_region_seoul = resources.getStringArray(R.array.spinner_region_seoul)
        val items_region_busan = resources.getStringArray(R.array.spinner_region_busan)
        val items_region_incheon = resources.getStringArray(R.array.spinner_region_incheon)
        val items_region_daegu = resources.getStringArray(R.array.spinner_region_daegu)
        val items_region_gwangju = resources.getStringArray(R.array.spinner_region_gwangju)
        val items_region_daejeon = resources.getStringArray(R.array.spinner_region_daejeon)
        val items_region_ulsan = resources.getStringArray(R.array.spinner_region_ulsan)
        val items_region_sejong = resources.getStringArray(R.array.spinner_region_sejong)
        val items_region_gyeonggi = resources.getStringArray(R.array.spinner_region_gyeonggi)
        val items_region_gangwon = resources.getStringArray(R.array.spinner_region_gangwon)
        val items_region_chung_buk = resources.getStringArray(R.array.spinner_region_chung_buk)
        val items_region_chung_nam = resources.getStringArray(R.array.spinner_region_chung_nam)
        val items_region_gyeong_buk = resources.getStringArray(R.array.spinner_region_gyeong_buk)
        val items_region_gyeong_nam = resources.getStringArray(R.array.spinner_region_gyeong_nam)
        val items_region_jeon_buk = resources.getStringArray(R.array.spinner_region_jeon_buk)
        val items_region_jeon_nam = resources.getStringArray(R.array.spinner_region_jeon_nam)
        val items_region_jeju = resources.getStringArray(R.array.spinner_region_jeju)

        val categoryAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items_category)
        val regionAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items_region)
        val seoulAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items_region_seoul)
        val busanAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items_region_busan)
        val incheonAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items_region_incheon)
        val daeguAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items_region_daegu)
        val gwangjuAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items_region_gwangju)
        val daejeonAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items_region_daejeon)
        val ulsanAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items_region_ulsan)
        val sejongAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items_region_sejong)
        val gyeonggiAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items_region_gyeonggi)
        val gangwonAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items_region_gangwon)
        val chungbukAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items_region_chung_buk)
        val chungnamAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items_region_chung_nam)
        val gyeongbukAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items_region_gyeong_buk)
        val gyeongnamAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items_region_gyeong_nam)
        val jeonbukAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items_region_jeon_buk)
        val jeonnamAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items_region_jeon_nam)
        val jejuAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items_region_jeju)


        // 뷰와 어뎁터 연결
        viewBinding.spinnerCategory.adapter = categoryAdapter
        viewBinding.spinnerCity.adapter = regionAdapter


        // 어뎁터가 연결된 뷰를 이용해서 이벤트 설정
        // 카테고리 스피너
        viewBinding.spinnerCategory.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, id: Long) {
                viewBinding.spinnerCity.selectedItem.toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                viewBinding.spinnerCategory.setSelection(0)
            }

        }

        // 시 스피너
        viewBinding.spinnerCity.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, id: Long) {
                viewBinding.spinnerCity.selectedItem.toString()

                // 0을 선택했을 경우는?
                when(viewBinding.spinnerCity.selectedItemPosition) {
                    0 -> viewBinding.spinnerDistrict.adapter = null
                    1 -> viewBinding.spinnerDistrict.adapter = seoulAdapter
                    2 -> viewBinding.spinnerDistrict.adapter = busanAdapter
                    3 -> viewBinding.spinnerDistrict.adapter = incheonAdapter
                    4 -> viewBinding.spinnerDistrict.adapter = daeguAdapter
                    5 -> viewBinding.spinnerDistrict.adapter = gwangjuAdapter
                    6 -> viewBinding.spinnerDistrict.adapter = daejeonAdapter
                    7 -> viewBinding.spinnerDistrict.adapter = ulsanAdapter
                    8 -> viewBinding.spinnerDistrict.adapter = sejongAdapter
                    9 -> viewBinding.spinnerDistrict.adapter = gyeonggiAdapter
                    10 -> viewBinding.spinnerDistrict.adapter = gangwonAdapter
                    11 -> viewBinding.spinnerDistrict.adapter = chungbukAdapter
                    12 -> viewBinding.spinnerDistrict.adapter = chungnamAdapter
                    13 -> viewBinding.spinnerDistrict.adapter = gyeongbukAdapter
                    14 -> viewBinding.spinnerDistrict.adapter = gyeongnamAdapter
                    15 -> viewBinding.spinnerDistrict.adapter = jeonbukAdapter
                    16 -> viewBinding.spinnerDistrict.adapter = jeonnamAdapter
                    17 -> viewBinding.spinnerDistrict.adapter = jejuAdapter
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                viewBinding.spinnerCity.setSelection(0)
            }
        }

        // 군 구 스피너
        viewBinding.spinnerDistrict.onItemSelectedListener = object  : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, id: Long) {
                viewBinding.spinnerCity.selectedItem.toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }
    }
}