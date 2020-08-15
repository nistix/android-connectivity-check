package com.nistix.connectivity.demo.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.nistix.connectivity.check.ConnectivityCheck
import com.nistix.connectivity.check.adapter.livedata.LiveData

class LiveDataViewModel : ViewModel() {

  val connectivityStatus: LiveData<Boolean> = ConnectivityCheck.LiveData

}
