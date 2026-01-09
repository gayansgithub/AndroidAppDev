package com.example.citymap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        findViewById<Button>(R.id.btnColombo).setOnClickListener {
            showCity(6.9271, 79.8612, "Colombo")
        }

        findViewById<Button>(R.id.btnKandy).setOnClickListener {
            showCity(7.2906, 80.6337, "Kandy")
        }

        findViewById<Button>(R.id.btnGalle).setOnClickListener {
            showCity(6.0535, 80.2210, "Galle")
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
    }

    private fun showCity(lat: Double, lng: Double, title: String) {
        val location = LatLng(lat, lng)
        mMap.clear()
        mMap.addMarker(
            MarkerOptions()
                .position(location)
                .title(title)
        )
        mMap.moveCamera(
            CameraUpdateFactory.newLatLngZoom(location, 12f)
        )
    }
}
