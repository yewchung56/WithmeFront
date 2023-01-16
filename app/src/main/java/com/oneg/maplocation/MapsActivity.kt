package com.oneg.maplocation

import android.annotation.SuppressLint
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.*

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import com.oneg.maplocation.databinding.ActivityMapsBinding
import java.io.IOException
import java.util.*
import java.util.jar.Manifest

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    val permissions = arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION )
    val PERM_FLAG = 99
    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(isPermitted()){
            startProcess()
        }else   {
            ActivityCompat.requestPermissions(this, permissions,PERM_FLAG)
        }
    }
    fun isPermitted():Boolean{
        for (perm in permissions){
            if(ContextCompat.checkSelfPermission(this, perm) != PERMISSION_GRANTED){
                return false
            }
        }
        return true
    }

    fun startProcess() {
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        //android를 호출하고 안드로이드가 구글맵을 호출한다.
        mapFragment.getMapAsync(this)
    }
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        setUpdateLocationListener()

    }

    //내위치를 가져오는 코드
    lateinit var fusedLocationClient:FusedLocationProviderClient
    lateinit var locationCallback:LocationCallback

    @SuppressLint("MissingPermission")
    fun setUpdateLocationListener(){
        //좌표값등록 갱신해줌
        val locationRequest = LocationRequest.create()
        locationRequest.run {
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
            interval = 1000
        }
        locationCallback = object : LocationCallback (){
            override fun onLocationResult(locationResult: LocationResult?) {
                locationResult?.let{
                    for((i, location)in it.locations.withIndex()){
                        Log.d("로케이션", "$i ${location.latitude}, ${location.longitude}")
                        setLastLocation(location)

                        var mGeocoder = Geocoder(applicationContext, Locale.KOREAN)
                        var mResultList: List<Address>? = null
                        var currentLocation : String = ""
                        val textView = findViewById<TextView>(R.id.textView)
                        try {
                            mResultList = mGeocoder.getFromLocation(
                                location.latitude!!, location.longitude!!,1
                            )
                        } catch (e: IOException){
                            e.printStackTrace()
                        }
                        if (mResultList != null){
                            Log.d("checkcurrentlocation", mResultList[0].getAddressLine(0))
                            currentLocation = mResultList[0].getAddressLine(0)
                            currentLocation = currentLocation.substring(9,20)
                        }
                        textView.text = currentLocation
                    }
                }
            }
        }
        //로케이션 요청함수 호출()
        fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, Looper.myLooper())
    }

    fun setLastLocation(location: Location){
        //마커아이콘만들기
        var bitmapDrawable:BitmapDrawable
        if(Build.VERSION.SDK_INT >=  Build.VERSION_CODES.LOLLIPOP){
            bitmapDrawable = getDrawable(R.drawable.marker) as BitmapDrawable
        } else {
            bitmapDrawable = resources.getDrawable(R.drawable.marker) as BitmapDrawable
        }
        //마커 크기변환
        val scaledBitmap = Bitmap.createScaledBitmap(bitmapDrawable.bitmap, 80, 100, false)
        val descriptor = BitmapDescriptorFactory.fromBitmap(scaledBitmap)
        val myLocation = LatLng(location.latitude, location.longitude)
        //마커
        val marker = MarkerOptions()
            .position(myLocation)
            .title("이 위치로 동네설정 하기")
            .icon(descriptor)
        //카메라위치
        val cameraOption = CameraPosition.Builder()
            .target(myLocation)
            .zoom(16f)
            .build()
        val camera = CameraUpdateFactory.newCameraPosition(cameraOption)

        mMap.addMarker(marker)
        mMap.moveCamera(camera)
    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when(requestCode){
            PERM_FLAG ->{
                var check = true
                for(grant in grantResults){
                    if(grant != PERMISSION_GRANTED){
                        check = false
                        break
                    }
                }
                if(check){
                    startProcess()
                }else{
                    Toast.makeText(this, "권한을 승인해야지만 앱을 사용할 수 있습니다",Toast.LENGTH_LONG).show()
                    finish()
                }
            }
        }
    }
}