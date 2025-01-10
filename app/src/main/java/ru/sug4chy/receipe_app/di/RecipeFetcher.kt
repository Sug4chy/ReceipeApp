package ru.sug4chy.receipe_app.di

import org.koin.core.annotation.Provided
import org.koin.core.annotation.Single
import ru.sug4chy.receipe_app.data.api.ApiService
import ru.sug4chy.receipe_app.data.dto.RecipeDto
import ru.sug4chy.receipe_app.data.dto.toSchema
import ru.sug4chy.receipe_app.domain.list_favorites.ListFavoritesUseCase
import ru.sug4chy.receipe_app.domain.list_recipes.Recipe

@Single
class RecipeFetcher(
    @Provided
    private val apiService: ApiService,
    private val listFavoritesUseCase: ListFavoritesUseCase
) {
    private var offset: Int = 0
    private val limit: Int = 10

    suspend fun getRecipesByIngredientsNextPage(ingredients: List<String>,  exclude: List<String>? = null): List<Recipe> {
        val recipeDto: List<RecipeDto> = if (exclude.isNullOrEmpty()) {
            apiService.getRecipesByIngredients(ingredients, offset, limit)
        } else {
            apiService.getRecipesByIngredientsWithExclusions(ingredients, exclude, offset, limit)
        }
        offset += limit
        return recipeDto.map {it.toSchema()}
    }

    suspend fun getRecipesNextPage(exclude: List<String>? = null): List<Recipe> {
        val favouriteRecipeIds = listFavoritesUseCase().map {it.id}
        val recipeDto: List<RecipeDto> = if (exclude.isNullOrEmpty()) {
            apiService.getRecipes(offset, limit)
        } else {
            apiService.getRecipesWithExclusions(exclude, offset, limit)
        }
        offset += limit
        return recipeDto.map {it.toSchema(isFavourite = favouriteRecipeIds.contains(it.id))}
    }


    fun resetPages() {
        offset = 0
    }


}