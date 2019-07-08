package com.aungkyawpaing.droidyangonsql.data.ormlite

import com.j256.ormlite.field.DatabaseField
import com.j256.ormlite.table.DatabaseTable

/**
 * Created by Vincent on 2019-07-02
 */

@DatabaseTable(tableName = "ballot")
data class BallotOrmLiteEntity(

  @DatabaseField(generatedId = false, columnName = "id")
  var id: Long? = null,

  @DatabaseField(columnName = "image")
  var image: String? = null,

  @DatabaseField(columnName = "isValid")
  var isValid: Boolean? = null
)