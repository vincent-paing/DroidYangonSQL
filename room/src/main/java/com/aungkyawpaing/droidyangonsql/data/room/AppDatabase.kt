package com.aungkyawpaing.droidyangonsql.data.room

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Created by Vincent on 2019-07-02
 */
@Database(entities = [BallotRoomEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

  abstract fun ballotDao(): BallotDao

}