package ru.sug4chy.receipe_app.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import ru.sug4chy.receipe_app.data.database.entity.Allergen
import ru.sug4chy.receipe_app.data.database.entity.FavoriteRecipe

@Dao
interface FavoriteRecipesDao {

    @Transaction
    @Query("SELECT * FROM favorite_recipe")
    suspend fun findAll(): List<FavoriteRecipe>

    @Transaction
    @Query("DELETE FROM favorite_recipe WHERE id = :id")
    suspend fun deleteById(id: Int)

    @Insert
    suspend fun save(recipe: FavoriteRecipe)
}