package com.etb.filemanager.files.file.properties

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.RequiresApi
import com.etb.filemanager.files.file.common.mime.MidiaType


data class FileProperties(  var title: String,
                            var property: String,
                            var isMedia: Boolean = false,
                            var mediaType: MidiaType = MidiaType.VIDEO,
                            var mediaPath: String = "") : Parcelable {
    @RequiresApi(Build.VERSION_CODES.Q)
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readBoolean(),
        parcel.readSerializable() as MidiaType,
        parcel.readString() ?: "",
    )

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(title)
        dest.writeString(property)
    }

    companion object CREATOR : Parcelable.Creator<FileProperties> {
        override fun createFromParcel(parcel: Parcel): FileProperties {
            return FileProperties(parcel)
        }

        override fun newArray(size: Int): Array<FileProperties?> {
            return arrayOfNulls(size)
        }
    }
}