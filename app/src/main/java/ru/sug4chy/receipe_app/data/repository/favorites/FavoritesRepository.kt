package ru.sug4chy.receipe_app.data.repository.favorites

import ru.sug4chy.receipe_app.data.database.entity.FavoriteRecipe

interface FavoritesRepository {
    suspend fun findAll(): List<FavoriteRecipe>
    suspend fun deleteById(id: Int)
    suspend fun add(
        id: Int,
        name: String,
        cookingTime: String,
        imageURL: String,
        manual: String,
        categories: String,
        ingredients: String
    )
}