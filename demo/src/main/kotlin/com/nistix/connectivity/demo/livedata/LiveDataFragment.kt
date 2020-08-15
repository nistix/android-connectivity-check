package com.nistix.connectivity.demo.livedata

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.nistix.connectivity.demo.R

class LiveDataFragment : Fragment() {
  private lateinit var viewModel: LiveDataViewModel
  private lateinit var statusTextView: TextView

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.connectivity_status_fragment, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    viewModel = ViewModelProvider(this).get(LiveDataViewModel::class.java)
    statusTextView = view.findViewById(R.id.statusTextView)

    viewModel.connectivityStatus.observe(viewLifecycleOwner, Observer { isConnected ->
      Log.d("ConnectivityCheck", "*** LiveDataFragment got isConnected=$isConnected")
      statusTextView.text = if (isConnected) "CONNECTED" else "NOT CONNECTED"
    })
  }

}
