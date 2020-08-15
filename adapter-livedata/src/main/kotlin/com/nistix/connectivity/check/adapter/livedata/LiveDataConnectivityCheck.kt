package com.nistix.connectivity.check.adapter.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.nistix.connectivity.check.ConnectivityCheck

val ConnectivityCheck.LiveData: LiveData<Boolean>
  get() = state

private val state = RefCountLiveData.distinct()

private object RefCountLiveData : MutableLiveData<Boolean>() {

  init {
    ConnectivityCheck.manager.listeners.add(::postValue)
  }

  override fun onActive() {
    super.onActive()
    ConnectivityCheck.manager.startListening()
  }

  override fun onInactive() {
    super.onInactive()
    ConnectivityCheck.manager.stopListening()
  }

}

internal fun <T> LiveData<T>.distinct(): LiveData<T> {
  return MediatorLiveData<T>().apply {
    addSource(this@distinct) { newValue -> if (newValue != value) value = newValue }
  }
}
