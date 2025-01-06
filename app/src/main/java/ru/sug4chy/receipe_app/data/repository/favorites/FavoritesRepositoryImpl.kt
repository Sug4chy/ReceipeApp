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
}