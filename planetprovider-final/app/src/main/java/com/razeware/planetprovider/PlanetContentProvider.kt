package com.razeware.planetprovider

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import android.database.sqlite.SQLiteDatabase
import android.content.UriMatcher
import androidx.core.content.ContentProviderCompat


class PlanetContentProvider : ContentProvider() {

  companion object {
    val NAME_CODE = 10
    val REBEL_BASE_CODE = 20

    val AUTHORITY = "com.razeware.planetprovider"
    val NAME_PATH = "name"
    val REBEL_BASE_PATH = "rebel_base"

    val uriMatcher = UriMatcher(UriMatcher.NO_MATCH)

    init {
      uriMatcher.addURI(AUTHORITY, NAME_PATH, NAME_CODE);
      uriMatcher.addURI(AUTHORITY, REBEL_BASE_PATH, REBEL_BASE_CODE);
    }
  }

  lateinit private var dbHelper: DBHelper
  lateinit private var db: SQLiteDatabase

  override fun insert(p0: Uri, p1: ContentValues?): Uri? {
    TODO("not implemented")
  }


  override fun query(uri: Uri, projection: Array<out String>?, selection: String?, selectionArgs: Array<out String>?, sortOrder: String?): Cursor {
    this.db = dbHelper.readableDatabase

    when (uriMatcher.match(uri)) {
      NAME_CODE -> return this.db.rawQuery("select id as _id, name from planets", arrayOf<String>())
      REBEL_BASE_CODE -> return this.db.rawQuery("select id as _id, name, rebel_base_lat, rebel_base_lng from planets", arrayOf<String>())
      else -> throw IllegalArgumentException("Unknown URI: " + uri)
    }
  }

  override fun onCreate(): Boolean {
    this.dbHelper = DBHelper(ContentProviderCompat.requireContext(this))
    return true
  }

  override fun update(p0: Uri, p1: ContentValues?, p2: String?, p3: Array<out String>?): Int {
    TODO("not implemented")
  }

  override fun delete(p0: Uri, p1: String?, p2: Array<out String>?): Int {
    TODO("not implemented")
  }

  override fun getType(p0: Uri): String {
    TODO("not implemented")
  }
}