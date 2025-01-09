package ru.sug4chy.receipe_app.domain.add_favourite

interface AddFavouriteUseCase {
    suspend operator fun invoke(
        name: String,
        cookingTime: String,
        imageURL: String,
        manual: String,
        categories: String,
        ingredients: String
    )
}