package com.bbteam.locationapp.service

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.location.LocationManager
import android.util.Log
import android.provider.Settings

class CurrentLatLong {
    private var gpsTracker: GPSTracker? = null
    var currentLat: Double = 0.0
    var currentLong: Double = 0.0
    internal var mcontext: Activity? = null
    internal var status = 0

    fun currentlatlong(context: Activity): Int {
        mcontext = context
        if (com.bbteam.locationapp.utils.NetWorkStatus.isNetworkAvailable(context)) {
            Navigation(context)
        } else {
            val alert = AlertDialog.Builder(mcontext)
            //alert.setIcon(android.R.drawable.ic_dialog_alert)
            alert.setTitle("")
            alert.setMessage("Network_unAvailable")
            alert.setPositiveButton("Ok") { dialog, which -> mcontext?.finish() }
            alert.show()
        }
        return status
    }

    fun Navigation(context: Activity) {
        val builder = AlertDialog.Builder(mcontext)
        if (hasGpsOnDevice()) {
            if (isGpsEnabledOnDevice) {
                try {
                    gpsTracker = GPSTracker(context)
                    currentLat = gpsTracker!!.getLocation()!!.latitude
                    currentLong = gpsTracker!!.getLocation()!!.longitude
                    status = 1
                    Log.d("location status", status.toString() + "")
                    Log.d("Latitude", currentLat.toString())
                    Log.d("Longtitude", currentLong.toString())
                } catch (e: Exception) {
                    Log.e("Navigation", "Error", e)
                }
            } else {
                showCustomDialog()
            }
        } else {
            //builder.setIcon(android.R.drawable.ic_dialog_alert)
            builder.setTitle("")
            builder.setMessage("This device does not have GPS feature")
            builder.setPositiveButton("Ok", null)
            builder.show()
        }
    }

    fun showCustomDialog() {
        val builder = AlertDialog.Builder(mcontext)
        //builder.setIcon(android.R.drawable.ic_dialog_alert)
        builder.setTitle("")
        builder.setMessage("Please enable your device GPS.")
        builder.setCancelable(false)
        builder.setPositiveButton("Ok") { dialog, which ->
            mcontext?.startActivityForResult(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS), 0)

        }
        builder.show()
    }

    fun hasGpsOnDevice(): Boolean {
        /*TODO Should check GPS enabled */
        return true
    }

    val isGpsEnabledOnDevice: Boolean
        get() {
            val mlocManager = mcontext?.getSystemService(Context.LOCATION_SERVICE) as LocationManager
            val isProviderEnabled = mlocManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
            return isProviderEnabled
        }

}