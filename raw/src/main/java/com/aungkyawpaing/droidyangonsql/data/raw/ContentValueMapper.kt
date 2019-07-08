package com.aungkyawpaing.droidyangonsql.data.raw

import android.content.ContentValues
import android.database.Cursor
import com.aungkyawpaing.droidyangonsql.data.Ballot

/**
 * Created by Vincent on 2019-07-02
 */
class BallotMapper {

  fun toContentValues(ballot: Ballot): ContentValues {
    val contentValues = ContentValues()
    contentValues.put("id", ballot.id)
    contentValues.put("image", ballot.image)
    if (ballot.isValid) {
      contentValues.put("isValid", 1)
    } else {
      contentValues.put("isValid", 0)
    }

    return contentValues
  }

  fun fromCursor(cursor: Cursor): Ballot {
    val id = cursor.getLong(cursor.getColumnIndex("id"))
    val imageUrl = cursor.getString(cursor.getColumnIndex("image"))
    val isValid = cursor.getInt(cursor.getColumnIndex("isValid")) == 1
    return Ballot(
      id = id,
      image = imageUrl,
      isValid = isValid
    )
  }

}