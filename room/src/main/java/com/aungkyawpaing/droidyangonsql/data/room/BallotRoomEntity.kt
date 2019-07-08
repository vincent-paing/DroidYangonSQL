package com.aungkyawpaing.droidyangonsql.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Vincent on 2019-07-02
 */
@Entity(tableName = "ballots")
data class BallotRoomEntity(
  @PrimaryKey val id: Long,
  @ColumnInfo(name = "name") val image: String,
  @ColumnInfo(name = "is_valid") val isValid: Boolean
)
