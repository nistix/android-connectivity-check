# Android connectivity check library 

This Android library provides a simple API about network connectivity changes: connected to any network or disconnected.
Library has a core module `com.nistix.connectivity-check:core`
and a set of adapters as well:
* LiveData: `com.nistix.connectivity-check:adapter-livedata`
* RxJava2 (coming soon)
* Kotlin Flow  (coming soon)

There is a demo app in the module `demo`.

The simple usage with LiveData:

```kotlin
ConnectivityCheck.LiveData.observe(viewLifecycleOwner, Observer { isConnected ->
  statusTextView.text = if (isConnected) "CONNECTED" else "NOT CONNECTED"
})
```
