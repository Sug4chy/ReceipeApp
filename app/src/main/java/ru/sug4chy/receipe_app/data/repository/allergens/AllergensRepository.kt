package ru.sug4chy.receipe_app.data.repository.allergens

import ru.sug4chy.receipe_app.data.database.entity.Allergen

interface AllergensRepository {
    suspend fun findAll(): List<Allergen>
    suspend fun add(name: String)
    suspend fun deleteById(id: Int)
}