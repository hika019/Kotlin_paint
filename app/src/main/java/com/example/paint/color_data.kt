package com.example.paint

import android.graphics.Path
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class pathInfo(
    var path: Path,
    var color: Int
)