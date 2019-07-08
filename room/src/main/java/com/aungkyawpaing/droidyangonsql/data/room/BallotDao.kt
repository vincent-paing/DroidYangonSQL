package com.aungkyawpaing.droidyangonsql.data.room

import androidx.room.Dao
import androidx.room.Query

/**
 * Created by Vincent on 2019-07-02
 */
@Dao
interface BallotDao {

  @Query("SELECT * FROM ballots WHERE is_valid = :isValid")
  fun getValidBallots(isValid: Boolean): List<BallotRoomEntity>

}