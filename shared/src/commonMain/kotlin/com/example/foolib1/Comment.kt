package com.example.foolib1

import kotlinx.serialization.Serializable
@Serializable
data class Comment(val id:Int,val email:String,val body:String)
