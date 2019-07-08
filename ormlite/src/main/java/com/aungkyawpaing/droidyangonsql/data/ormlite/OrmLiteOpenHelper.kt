package com.aungkyawpaing.droidyangonsql.data.ormlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper
import com.j256.ormlite.support.ConnectionSource
import com.j256.ormlite.table.TableUtils

/**
 * Created by Vincent on 2019-07-02
 */
class OrmLiteOpenHelper constructor(context: Context) : OrmLiteSqliteOpenHelper(
  context,
  "droidyangon.db",
  null,
  1
) {
  override fun onCreate(database: SQLiteDatabase?, connectionSource: ConnectionSource?) {
    TableUtils.createTableIfNotExists(connectionSource, BallotOrmLiteEntity::class.java)
  }

  override fun onUpgrade(
    database: SQLiteDatabase?,
    connectionSource: ConnectionSource?,
    oldVersion: Int,
    newVersion: Int
  ) {
    TableUtils.dropTable<BallotOrmLiteEntity, Any>(
      connectionSource,
      BallotOrmLiteEntity::class.java,
      true
    )
    onCreate(database, connectionSource)
  }

}