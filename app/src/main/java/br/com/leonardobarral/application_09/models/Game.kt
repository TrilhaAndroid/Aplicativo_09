package br.com.leonardobarral.application_09.models

data class Game(
    val id: Long = 0,
    val title: String = "",
    val studio: String = "",
    val releaseYear: Int = 0
)