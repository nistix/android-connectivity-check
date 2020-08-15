package com.nistix.connectivity.demo.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

  private val _text = MutableLiveData<String>().apply {
    value = "Select adapter in the left menu"
  }
  val text: LiveData<String> = _text

}
