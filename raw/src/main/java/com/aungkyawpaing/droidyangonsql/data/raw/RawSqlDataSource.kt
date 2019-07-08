package com.aungkyawpaing.droidyangonsql.data.raw

import android.database.Cursor
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper
import androidx.sqlite.db.SupportSQLiteQueryBuilder
import com.aungkyawpaing.droidyangonsql.data.Ballot
import com.aungkyawpaing.droidyangonsql.data.DataSource

/**
 * Created by Vincent on 2019-07-01
 */
class RawSqlDataSource(
  private val sqlLiteOpenHelper: SupportSQLiteOpenHelper
) : DataSource {

  override fun getValidBallots(): List<Ballot> {
    var cursor: Cursor? = null
    var database: SupportSQLiteDatabase? = null

    try {
      database = sqlLiteOpenHelper.readableDatabase

      val sqlLiteQuery = SupportSQLiteQueryBuilder.builder("BALLOT_TABLE")
        .selection("isValid", arrayOf(1))
        .create()

      cursor = database.query(sqlLiteQuery)

      val ballotList = mutableListOf<Ballot>()
      if (cursor.moveToFirst()) {
        while (!cursor.isAfterLast) {
          val id = cursor.getLong(cursor.getColumnIndexOrThrow("id"))
          val imageUrl = cursor.getString(cursor.getColumnIndexOrThrow("image"))
          val isValid = cursor.getInt(cursor.getColumnIndexOrThrow("isValid")) == 1
          ballotList.add(Ballot(id, imageUrl, isValid))
          cursor.moveToNext()
        }
      }

      return ballotList

    } catch (exception: Exception) {
      exception.printStackTrace()
    } finally {
      cursor?.close()
      database?.close()
    }

    return emptyList()
  }

}