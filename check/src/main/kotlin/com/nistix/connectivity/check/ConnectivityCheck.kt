package com.nistix.connectivity.check

import android.os.Build
import com.nistix.connectivity.check.api21.Api21CheckManager

internal const val TAG = "ConnectivityCheck"

object ConnectivityCheck {

  val manager: CheckManager by lazy {
    when (Build.VERSION.SDK_INT) {
      in Build.VERSION_CODES.LOLLIPOP..Int.MAX_VALUE -> Api21CheckManager(InitProvider.appContext)
      else                                           -> error("Not supported yet")
    }
  }

}
