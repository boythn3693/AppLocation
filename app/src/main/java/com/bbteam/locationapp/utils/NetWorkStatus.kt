package com.bbteam.locationapp.utils

import android.content.Context
import android.net.ConnectivityManager

/**
 * Created by BacNguyen on 4/8/2018.
 */

object NetWorkStatus {
    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null
    }
}