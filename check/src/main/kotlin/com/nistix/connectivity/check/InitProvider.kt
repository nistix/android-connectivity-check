package com.nistix.connectivity.check

import android.content.ContentProvider
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.net.Uri

class InitProvider : ContentProvider() {

  override fun onCreate(): Boolean {
    appContext = context!!.applicationContext
    return true
  }

  override fun getType(uri: Uri): String? = null

  override fun query(
    uri: Uri, projection: Array<out String>?, selection: String?, selectionArgs: Array<out String>?, sortOrder: String?
  ): Cursor? = null

  override fun insert(uri: Uri, values: ContentValues?): Uri? = null

  override fun update(uri: Uri, values: ContentValues?, selection: String?, selectionArgs: Array<out String>?): Int = 0

  override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int = 0

  companion object {
    internal lateinit var appContext: Context
  }

}
