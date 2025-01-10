package ru.sug4chy.receipe_app.data.repository.favorites

import org.koin.core.annotation.Provided
import org.koin.core.annotation.Single
import ru.sug4chy.receipe_app.data.database.dao.FavoriteRecipesDao
import ru.sug4chy.receipe_app.data.database.entity.FavoriteRecipe

@Single
class FavoritesRepositoryImpl(
    @Provided private val favoriteRecipesDao: FavoriteRecipesDao
) : FavoritesRepository {

    override suspend fun findAll(): List<FavoriteRecipe> =
        favoriteRecipesDao.findAll()

    override suspend fun deleteById(id: Int) =
        favoriteRecipesDao.deleteById(id)

    override suspend fun add(
        id: Int,
        name: String,
        cookingTime: String,
        imageURL: String,
        manual: String,
        categories: String,
        ingredients: String
    ) {
        val favoriteRecipe = FavoriteRecipe(
            id = id,
            name = name,
            cookingTime = cookingTime,
            imageURL = imageURL,
            manual = manual,
            categories = categories,
            ingredients = ingredients
        )
        favoriteRecipesDao.save(favoriteRecipe)
    }
}