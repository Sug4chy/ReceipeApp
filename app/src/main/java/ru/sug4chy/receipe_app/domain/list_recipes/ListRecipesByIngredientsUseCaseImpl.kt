package ru.sug4chy.receipe_app.domain.list_recipes

import org.koin.core.annotation.Single

@Single
internal class ListRecipesByIngredientsUseCaseImpl (
    private val ingredients: List<String>
) : ListRecipesUseCase {

    override suspend fun invoke(): List<Recipe> {
        TODO("api give me list recipe")
    }

}