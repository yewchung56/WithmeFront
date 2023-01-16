package com.umc.withmeproject

import android.content.pm.PackageManager
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.umc.withmeproject.databinding.ActivityAddressFindBinding
import java.util.*
import java.util.jar.Manifest

class AddressFindActivity : AppCompatActivity() {

    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private val TAG = "AddressFindActivity"
    // private lateinit var geocoder: Geocoder

    private lateinit var viewBinding: ActivityAddressFindBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityAddressFindBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)

        // geocoder = Geocoder(this, Locale.KOREA)

        getlastLocation()
    }

    private fun getlastLocation() {
        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), 101)
        }

        val lastLocation = fusedLocationProviderClient.lastLocation

        lastLocation.addOnSuccessListener {
            if(it != null) {
                Log.d(TAG, "getLastLocation: ${it.latitude}")
                Log.d(TAG, "getLastLocation: ${it.longitude}")

                //val address = geocoder.getFromLocation(it.latitude, it.longitude, 1)

                //Log.d(TAG, "getLastLocation: ${address[0].getAddressLine(0)}")
                //Log.d(TAG, "getLastLocation: ${address[0].locality}")
            }
        }

        lastLocation.addOnFailureListener {
            Log.d(TAG, "getLastLocation: Failed to load location")
        }
    }
}