package com.example.tugasfundandro

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@kotlinx.android.parcel.Parcelize
data class Notes(
    val title: String,
    val isi: String
):Parcelable
