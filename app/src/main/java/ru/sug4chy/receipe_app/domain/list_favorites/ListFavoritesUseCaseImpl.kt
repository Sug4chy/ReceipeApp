package ru.sug4chy.receipe_app.domain.list_favorites

import org.koin.core.annotation.Single
import ru.sug4chy.receipe_app.data.database.entity.FavoriteRecipe
import ru.sug4chy.receipe_app.data.repository.favorites.FavoritesRepository

@Single
class ListFavoritesUseCaseImpl(
    private val favoritesRepository: FavoritesRepository
) : ListFavoritesUseCase {

    override suspend fun invoke(): List<FavoriteRecipe> =
        favoritesRepository.findAll()
}