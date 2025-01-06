package ru.sug4chy.receipe_app.domain.list_favorites

import ru.sug4chy.receipe_app.data.database.entity.FavoriteRecipe

interface ListFavoritesUseCase {
    suspend operator fun invoke(): List<FavoriteRecipe>
}