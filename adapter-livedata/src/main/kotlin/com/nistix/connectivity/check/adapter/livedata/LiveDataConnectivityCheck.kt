package com.nistix.connectivity.check.adapter.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.nistix.connectivity.check.ConnectivityCheck

val ConnectivityCheck.LiveData: LiveData<Boolean>
  get() = state

private val state = RefCountLiveData.distinct()

private object RefCountLiveData : MutableLiveData<Boolean>() {
  private val listener = ::postValue

  override fun onActive() {
    super.onActive()
    ConnectivityCheck.manager.addListener(listener)
  }

  override fun onInactive() {
    super.onInactive()
    ConnectivityCheck.manager.removeListener(listener)
  }

}

internal fun <T> LiveData<T>.distinct(): LiveData<T> {
  return MediatorLiveData<T>().apply {
    addSource(this@distinct) { newValue -> if (newValue != value) value = newValue }
  }
}
