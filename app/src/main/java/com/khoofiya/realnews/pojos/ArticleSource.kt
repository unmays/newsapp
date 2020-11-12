package com.khoofiya.realnews.pojos

import android.os.Parcel
import android.os.Parcelable
import io.realm.RealmObject

open class ArticleSource(
    var id: String? = null,
    var name: String? = null
) : RealmObject(), Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ArticleSource> {
        override fun createFromParcel(parcel: Parcel): ArticleSource {
            return ArticleSource(parcel)
        }

        override fun newArray(size: Int): Array<ArticleSource?> {
            return arrayOfNulls(size)
        }
    }
}