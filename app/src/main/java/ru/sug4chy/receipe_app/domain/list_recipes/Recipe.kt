package ru.sug4chy.receipe_app.domain.list_recipes

data class Recipe (
    val name: String,
    val cook_time: String,
    val manual: String,
    val id: Int,
    val ingredient: String,
    val category: String,
    val link: String
)