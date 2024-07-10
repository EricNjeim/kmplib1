package com.example.foolib1

import kotlinx.serialization.Serializable

@Serializable
data class Photo(val id:Int,val title:String, val thumbnailUrl:String)
