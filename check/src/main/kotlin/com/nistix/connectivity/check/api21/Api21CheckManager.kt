package com.nistix.connectivity.check.api21

import android.annotation.TargetApi
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Build
import android.util.Log
import androidx.core.content.ContextCompat
import com.nistix.connectivity.check.CheckManager
import com.nistix.connectivity.check.TAG
import java.util.concurrent.atomic.AtomicReference

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
internal class Api21CheckManager(context: Context) : CheckManager() {
  private val manager = ContextCompat.getSystemService(context, ConnectivityManager::class.java)
  private val callback = AtomicReference<NetworkCallback>(null)

  override fun startListening() {
    Log.d(TAG, "Api21CheckManager.startListening()")

    if (!isConnectedNow()) isConnected = false

    val newCallback = NetworkCallback(listener)
    callback.getAndSet(newCallback)?.let { prevCallback -> manager?.unregisterNetworkCallback(prevCallback) }
    val networkRequest = NetworkRequest.Builder()
      .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
      .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
      .addTransportType(NetworkCapabilities.TRANSPORT_ETHERNET)
      .build()
    manager?.registerNetworkCallback(networkRequest, newCallback)
  }

  override fun stopListening() {
    Log.d(TAG, "Api21CheckManager.stopListening()")
    callback.getAndSet(null)?.let { prevCallback -> manager?.unregisterNetworkCallback(prevCallback) }
  }

  @Suppress("DEPRECATION")
  private fun isConnectedNow(): Boolean {
    return manager?.activeNetworkInfo?.isConnected == true
  }

  private val listener: (Boolean) -> Unit = {
    isConnected = it
  }

}
