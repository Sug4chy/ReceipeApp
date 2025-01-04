package ru.sug4chy.receipe_app.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ru.sug4chy.receipe_app.data.database.entity.Allergen

@Dao
interface AllergensDao {

    @Query("SELECT * FROM allergen")
    suspend fun findAll(): List<Allergen>

    @Insert
    suspend fun save(allergen: Allergen)

    @Query("DELETE FROM allergen WHERE id = :id")
    suspend fun deleteById(id: Int)
}