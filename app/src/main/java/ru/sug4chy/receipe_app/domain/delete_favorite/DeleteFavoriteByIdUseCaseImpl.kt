package ru.sug4chy.receipe_app.domain.delete_favorite

import org.koin.core.annotation.Single
import ru.sug4chy.receipe_app.data.repository.favorites.FavoritesRepository

@Single
class DeleteFavoriteByIdUseCaseImpl(
    private val favoritesRepository: FavoritesRepository
) : DeleteFavoriteByIdUseCase {

    override suspend fun invoke(id: Int) =
        favoritesRepository.deleteById(id)
}