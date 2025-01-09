package ru.sug4chy.receipe_app.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.sug4chy.receipe_app.data.database.dao.AllergensDao
import ru.sug4chy.receipe_app.data.database.dao.FavoriteRecipesDao
import ru.sug4chy.receipe_app.data.database.entity.Allergen
import ru.sug4chy.receipe_app.data.database.entity.FavoriteRecipe

@Database(
    entities = [
        Allergen::class,
        FavoriteRecipe::class,
    ],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun allergensDao(): AllergensDao
    abstract fun favoriteRecipesDao(): FavoriteRecipesDao
}