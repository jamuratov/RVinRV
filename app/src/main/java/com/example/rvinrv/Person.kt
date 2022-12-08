package com.example.rvinrv

import androidx.annotation.DrawableRes

data class Person(
    val id: Int,
    @DrawableRes val Image: Int,
    @DrawableRes val Imagem_mini: Int,
    val name: String
)