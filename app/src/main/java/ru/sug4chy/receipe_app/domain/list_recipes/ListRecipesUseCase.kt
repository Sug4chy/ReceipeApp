package ru.sug4chy.receipe_app.domain.list_recipes

interface ListRecipesUseCase {
    suspend operator fun invoke(): List<Recipe>
}