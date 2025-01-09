package ru.sug4chy.receipe_app.domain.list_recipes

import org.koin.core.annotation.Single
import ru.sug4chy.receipe_app.di.RecipeFetcher

@Single
class ListRecipesUseCaseImpl(
    private val recipeFetcher: RecipeFetcher
): ListRecipesUseCase {

    override suspend fun invoke(): List<Recipe> {
        return recipeFetcher.getRecipesNextPage()
    }
}