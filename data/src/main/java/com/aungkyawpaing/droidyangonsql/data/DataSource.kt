package com.aungkyawpaing.droidyangonsql.data

/**
 * Created by Vincent on 2019-07-01
 */

interface DataSource {

  fun getValidBallots(): List<Ballot>
}