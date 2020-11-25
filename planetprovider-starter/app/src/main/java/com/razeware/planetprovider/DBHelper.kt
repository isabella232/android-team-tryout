package com.razeware.planetprovider

import android.content.Context
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper

/**
 * Created by joehoward on 8/2/17.
 */
class DBHelper(context: Context) : SQLiteAssetHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
  companion object {
    private val DATABASE_NAME = "planets.db"
    private val DATABASE_VERSION = 1
  }
}