package com.bbteam.locationapp.service

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.util.Log


class GPSTracker(mmContext: Context) : LocationListener {

    private val MIN_DISTANCE_CHANGE_FOR_UPDATES: Long = 10 // 10 meters
    private val MIN_TIME_BW_UPDATES = (1000 * 10 * 1).toLong() // 10 seconds
    private var location: Location? = null
    private var latitude: Double = 0.toDouble()
    private var longitude: Double = 0.toDouble()

    private var locationManager: LocationManager? = null
    private var mContext:Context=mmContext


    @SuppressLint("MissingPermission")
    fun getLocation(): Location? {
        locationManager = mContext.getSystemService(Context.LOCATION_SERVICE) as LocationManager

        locationManager!!.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                MIN_TIME_BW_UPDATES,
                MIN_DISTANCE_CHANGE_FOR_UPDATES.toFloat(), this)
        Log.d("GPS", "GPS Enabled")
        if(locationManager != null) {
            location = locationManager!!.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
            Log.d("location", location!!.toString())
            if(location != null) {
                latitude = location!!.latitude
                longitude = location!!.longitude
            }
        }
        return location
    }

    fun getLatitude(): Double {
        if (location != null) {
            latitude = location!!.latitude
        }
        return latitude
    }

    fun getLongitude(): Double {
        if (location != null) {
            longitude = location!!.longitude
        }
        return longitude
    }

    override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onProviderEnabled(p0: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onProviderDisabled(p0: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onLocationChanged(p0: Location?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}