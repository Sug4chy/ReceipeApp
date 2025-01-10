package ru.sug4chy.receipe_app.domain.list_recipes

import org.koin.core.annotation.Single
import ru.sug4chy.receipe_app.data.repository.allergens.AllergensRepository
import ru.sug4chy.receipe_app.di.RecipeFetcher


@Single
class ListRecipesByIngredientsUseCaseImpl (
    private val recipeFetcher: RecipeFetcher,
    private val allergensRepository: AllergensRepository
) : ListRecipesUseCase {

    private var ingredients: List<String> = emptyList()

    fun setIngredients(newIngredients: List<String>) {
        ingredients = newIngredients
    }

    fun resetPages() {
        recipeFetcher.resetPages()
    }

    override suspend fun invoke(): List<Recipe> {
        val exclude = allergensRepository.findAll().map { it.name }
        return recipeFetcher.getRecipesByIngredientsNextPage(ingredients, exclude)
    }
}