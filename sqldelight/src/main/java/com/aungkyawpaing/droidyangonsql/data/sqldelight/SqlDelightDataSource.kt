package com.aungkyawpaing.droidyangonsql.data.sqldelight

import android.content.Context
import com.aungkyawpaing.droidyangonsql.data.DataSource
import com.example.sqldelight.ExampleDb
import com.squareup.sqldelight.ColumnAdapter
import com.squareup.sqldelight.android.AndroidSqliteDriver
import org.threeten.bp.Instant

/**
 * Created by Vincent on 2019-07-04
 */
class SqlDelightDataSource constructor(
  private val context: Context
) : DataSource {
  override fun getValidBallots(): List<com.aungkyawpaing.droidyangonsql.data.Ballot> {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  private val instantColumnAdapter = object : ColumnAdapter<Instant, Long> {
    override fun decode(databaseValue: Long): Instant {
      return Instant.ofEpochMilli(databaseValue)
    }

    override fun encode(value: Instant): Long {
      return value.toEpochMilli()
    }

  }

  private val ballotColumnAdapter = Ballot.Adapter(
    added_dateAdapter = instantColumnAdapter
  )

  private val driver = AndroidSqliteDriver(ExampleDb.Schema, context, "example.db")
  private val exampleDb = ExampleDb(driver, ballotColumnAdapter)

  private val ballotQueries = exampleDb.ballotQueries
//
//  override fun getValidBallots(): List<Ballot> {
//    return ballotQueries.select_valid_only { id, image, added_date, is_valid ->
//      Ballot(
//        id,
//        image,
//        is_valid
//      )
//    }.executeAsList()
//  }

}