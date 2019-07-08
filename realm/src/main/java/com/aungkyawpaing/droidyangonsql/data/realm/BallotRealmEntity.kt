package com.aungkyawpaing.droidyangonsql.data.realm

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by Vincent on 2019-07-02
 */
open class BallotRealmEntity : RealmObject() {
  @PrimaryKey var id: Long = 0

  var image: String = ""

  var isValidBallot: Boolean = true
}
