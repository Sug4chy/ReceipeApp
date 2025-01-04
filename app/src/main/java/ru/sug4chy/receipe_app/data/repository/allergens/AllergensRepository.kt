package ru.sug4chy.receipe_app.data.repository.allergens

import ru.sug4chy.receipe_app.data.model.Allergen

interface AllergensRepository {
    suspend fun findAll(): Result<List<Allergen>>
}