package com.nistix.connectivity.check

import android.util.Log
import kotlin.properties.Delegates

abstract class CheckManager {
  private val listeners = mutableListOf<(Boolean) -> Unit>()

  fun addListener(listener: (Boolean) -> Unit) {
    val wasEmpty = listeners.isEmpty()
    Log.d(TAG, "CheckManager.addListener() (wasEmpty=$wasEmpty)")
    listeners.add(listener)
    if (wasEmpty) startListening()
    else listener(isConnected)
  }

  fun removeListener(listener: (Boolean) -> Unit) {
    listeners.remove(listener)
    val nowEmpty = listeners.isEmpty()
    Log.d(TAG, "CheckManager.removeListener() (nowEmpty=$nowEmpty)")
    if (nowEmpty) stopListening()
  }

  protected abstract fun startListening()

  protected abstract fun stopListening()

  protected var isConnected: Boolean by Delegates.observable(false) { _, _, newValue ->
    Log.d(TAG, "CheckManager isConnected changed its value to '$newValue'; listeners count = ${listeners.size}")
    listeners.forEach { it(newValue) }
  }

}
