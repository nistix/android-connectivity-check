package com.nistix.connectivity.demo.rxjava2

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.nistix.connectivity.check.ConnectivityCheck
import com.nistix.connectivity.check.adapter.rxjava2.RxJava2
import com.nistix.connectivity.demo.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

class RxJava2Fragment : Fragment() {
  private val subscriptions = CompositeDisposable()
  private lateinit var statusTextView: TextView

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.connectivity_status_fragment, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    statusTextView = view.findViewById(R.id.statusTextView)

    subscriptions.add(
      ConnectivityCheck.RxJava2
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe { isConnected ->
          Log.d("ConnectivityCheck", "*** RxJava2Fragment got isConnected=$isConnected")
          statusTextView.text = if (isConnected) "CONNECTED" else "NOT CONNECTED"
        }
    )
  }

  override fun onDestroyView() {
    super.onDestroyView()
    subscriptions.clear()
  }

}
