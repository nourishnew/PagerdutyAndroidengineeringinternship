package com.example.android.pagerduty.dish

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Dish(var name: String,var description: String,var index:Int ) : Parcelable