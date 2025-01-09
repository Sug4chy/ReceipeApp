package ru.sug4chy.receipe_app.domain.list_recipes

import org.koin.core.annotation.Single
import ru.sug4chy.receipe_app.di.RecipeFetcher


@Single
class ListRecipesByIngredientsUseCaseImpl (
    private val recipeFetcher: RecipeFetcher
) : ListRecipesUseCase {

    private var ingredients: List<String> = emptyList()

    fun setIngredients(newIngredients: List<String>) {
        ingredients = newIngredients
    }

    override suspend fun invoke(): List<Recipe> {
        return recipeFetcher.getRecipesNextPage(ingredients)
    }
}