package com.aungkyawpaing.droidyangonsql.data.ormlite

import com.aungkyawpaing.droidyangonsql.data.Ballot
import com.aungkyawpaing.droidyangonsql.data.DataSource

/**
 * Created by Vincent on 2019-07-02
 */
class OrmLiteDataSource constructor(private val ormLiteOpenHelper: OrmLiteOpenHelper) : DataSource {

  private val ballotDao = ormLiteOpenHelper.getDao(BallotOrmLiteEntity::class.java)

  override fun getValidBallots(): List<Ballot> {
    return ballotDao
      .queryForEq("isValid'", true)
      .map {
        Ballot(
          id = it.id!!,
          image = it.image!!,
          isValid = it.isValid!!
        )
      }
  }

}