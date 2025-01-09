package ru.sug4chy.receipe_app.di

import android.util.Log
import org.koin.core.annotation.Provided
import org.koin.core.annotation.Single
import ru.sug4chy.receipe_app.data.api.ApiService
import ru.sug4chy.receipe_app.data.dto.RecipeDto
import ru.sug4chy.receipe_app.data.dto.toSchema
import ru.sug4chy.receipe_app.domain.list_recipes.Recipe

@Single
class RecipeFetcher(
    @Provided
    private val apiService: ApiService
) {
    private var offset: Int = 0
    private val limit: Int = 10

    suspend fun getRecipesNextPage(ingredients: List<String>): List<Recipe> {
        Log.d("RecipeFetcher", "Fetching recipes with offset=$offset, limit=$limit")
        val recipeDto: List<RecipeDto> = apiService.getRecipesByIngredients(ingredients, offset, limit)
        offset += limit
        return recipeDto.map {it.toSchema()}
    }

    suspend fun getRecipesNextPage(): List<Recipe> {
        val recipeDto: List<RecipeDto> = apiService.getRecipes(offset, limit)
        offset += limit
        return recipeDto.map {it.toSchema()}
    }

    fun resetPages() {
        offset = 0
    }


}