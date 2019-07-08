package com.aungkyawpaing.droidyangonsql.data.realm

import com.aungkyawpaing.droidyangonsql.data.Ballot
import com.aungkyawpaing.droidyangonsql.data.DataSource
import io.realm.Realm

/**
 * Created by Vincent on 2019-07-02
 */
class RealmDataSource constructor(private val realm: Realm) : DataSource {

  override fun getValidBallots(): List<Ballot> {
    return realm.where(BallotRealmEntity::class.java)
      .equalTo("isValidBallot", true)
      .findAll()
      .map {
        Ballot(
          id = it.id,
          image = it.image,
          isValid = it.isValidBallot
        )
      }
  }
}
