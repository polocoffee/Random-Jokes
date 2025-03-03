package com.banklannister.randomjokes.data

import kotlinx.serialization.Serializable

@Serializable
data class JokesModel(
    val id:String,
    val joke:String = "",
    val status: Int = 200
)