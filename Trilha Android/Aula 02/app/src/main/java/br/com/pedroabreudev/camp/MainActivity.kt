package br.com.pedroabreudev.camp

import android.Manifest
import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.location.Location
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.motion.widget.Debug
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

class MainActivity : AppCompatActivity() {

    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var lastLocation: AppCompatTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i(TAG, "onCreate: Main ")
        checkPermissionAndGetLocation()

        lastLocation = findViewById(R.id.lastLocation)
    }

    private fun checkPermissionAndGetLocation() {
        val locationPermissionRequest = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { permissions ->
            if (permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true &&
                permissions[Manifest.permission.ACCESS_COARSE_LOCATION] == true
            ) {
                getLocation()
            } else {
                Toast.makeText(
                    baseContext,
                    "Você precisa permitir a localização!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        locationPermissionRequest.launch(
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        )
    }


    @SuppressLint("MissingPermission")
    private fun getLocation() {
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location: Location? ->
                lastLocation.text =
                    "Latitude: ${location?.latitude} \nLongitude: ${location?.longitude}"
            }
            .addOnFailureListener {
                lastLocation.text = it.message
            }
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart: Main")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume: Main")
    }


    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "onRestart: Main")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause: Main")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop: Main")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy: Main")
    }

}