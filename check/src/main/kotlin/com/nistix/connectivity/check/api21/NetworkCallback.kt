package com.nistix.connectivity.check.api21

import android.annotation.TargetApi
import android.net.ConnectivityManager
import android.net.Network
import android.os.Build
import android.util.Log
import com.nistix.connectivity.check.TAG
import java.lang.ref.WeakReference

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
internal class NetworkCallback(listener: (Boolean) -> Unit) : ConnectivityManager.NetworkCallback() {
  private val listener = WeakReference<(Boolean) -> Unit>(listener)
  private val availableNetworks = mutableSetOf<String>()

  override fun onAvailable(network: Network) {
    val s: String = network.toString()
    Log.d(TAG, "NetworkCallback.onAvailable(): network=$network)")
    super.onAvailable(network)
    availableNetworks.add(network.toString())
    updateStatus()
  }

  override fun onLost(network: Network) {
    val s: String = network.toString()
    Log.d(TAG, "NetworkCallback.onLost(): network=$network)")
    super.onLost(network)
    availableNetworks.remove(network.toString())
    updateStatus()
  }

  private fun updateStatus() {
    Log.d(TAG, "NetworkCallback.updateStatus(): networks=$availableNetworks")
    if (availableNetworks.isEmpty()) listener.get()?.invoke(false)
    else listener.get()?.invoke(true)
  }

}
