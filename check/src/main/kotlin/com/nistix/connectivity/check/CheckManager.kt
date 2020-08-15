package com.nistix.connectivity.check

import kotlin.properties.Delegates

abstract class CheckManager {
  val listeners = mutableListOf<(Boolean) -> Unit>()

  abstract fun startListening()

  abstract fun stopListening()

  protected var isConnected: Boolean by Delegates.observable(false) { _, _, newValue ->
    listeners.forEach { it(newValue) }
  }

}
