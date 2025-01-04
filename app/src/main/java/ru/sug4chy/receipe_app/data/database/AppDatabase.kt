package ru.sug4chy.receipe_app.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.sug4chy.receipe_app.data.database.dao.AllergensDao
import ru.sug4chy.receipe_app.data.database.entity.Allergen

@Database(
    entities = [Allergen::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun allergensDao(): AllergensDao
}