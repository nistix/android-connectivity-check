# Android connectivity check library 

This Android library provides a simple API about network connectivity changes: connected to any network or disconnected.

Library has a core module `com.nistix.connectivity-check:core`
and a set of adapters as well:
* LiveData: `com.nistix.connectivity-check:adapter-livedata`
* RxJava2 (coming soon)
* Kotlin Flow  (coming soon)

## Usage

There is a **demo app** in the module `demo`.

The simple usage with LiveData:

```kotlin
ConnectivityCheck.LiveData.observe(viewLifecycleOwner, Observer { isConnected ->
  statusTextView.text = if (isConnected) "CONNECTED" else "NOT CONNECTED"
})
```

## Download

KotlinDSL:

```kotlin
implementation("com.nistix.connectivity-check:core:1.0.0")
implementation("com.nistix.connectivity-check:adapter-livedata:1.0.0")
```

Groovy:

```groovy
implementation 'com.nistix.connectivity-check:core:1.0.0'
implementation 'com.nistix.connectivity-check:adapter-livedata:1.0.0'
```

## License

```
MIT License

Copyright (c) 2020 Oleg Mezentsev

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
