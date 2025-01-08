package ru.sug4chy.receipe_app.domain.list_recipes

import org.koin.core.annotation.Single

@Single
internal class ListRecipesUseCaseImpl (
    private val category: String
) : ListRecipesUseCase {

    override suspend fun invoke(): List<Recipe> {
        TODO("Not yet implemented")
    }
}