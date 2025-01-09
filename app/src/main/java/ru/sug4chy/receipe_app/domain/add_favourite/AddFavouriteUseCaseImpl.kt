package ru.sug4chy.receipe_app.domain.add_favourite

import org.koin.core.annotation.Single
import ru.sug4chy.receipe_app.data.repository.favorites.FavoritesRepository


@Single
internal class AddFavouriteUseCaseImpl(
    private val favouriteRepository: FavoritesRepository
) : AddFavouriteUseCase{

    override suspend fun invoke(
                                name: String,
                                cookingTime: String,
                                imageURL: String,
                                manual: String,
                                categories: String,
                                ingredients: String
                                ) = favouriteRepository.add(
                                                            name,
                                                            cookingTime,
                                                            imageURL,
                                                            manual,
                                                            categories,
                                                            ingredients
                                                            )
}