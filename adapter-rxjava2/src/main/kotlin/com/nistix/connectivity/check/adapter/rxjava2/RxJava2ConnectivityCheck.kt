package com.nistix.connectivity.check.adapter.rxjava2

import com.nistix.connectivity.check.ConnectivityCheck
import io.reactivex.Observable

val ConnectivityCheck.RxJava2: Observable<Boolean>
  get() = RefCountShareObservable.state

private object RefCountShareObservable {
  val state = Observable.create<Boolean> {
    val listener: (Boolean) -> Unit = { isConnected ->
      if (!it.isDisposed) it.onNext(isConnected)
    }
    ConnectivityCheck.manager.addListener(listener)
    it.setCancellable { ConnectivityCheck.manager.removeListener(listener) }
  }
    .publish()
    .refCount()
}
