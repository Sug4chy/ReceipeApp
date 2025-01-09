package ru.sug4chy.receipe_app.data.api

import retrofit2.http.GET
import retrofit2.http.Query
import ru.sug4chy.receipe_app.data.dto.RecipeDto

interface ApiService {
    @GET("recipes")
    suspend fun getRecipes(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): List<RecipeDto>

    @GET("recipes/ingredients")
    suspend fun getRecipesByIngredients(
        @Query("ingredients") ingredients: List<String>,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): List<RecipeDto>
}