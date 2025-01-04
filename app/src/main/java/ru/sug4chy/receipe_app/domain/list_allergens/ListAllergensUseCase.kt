package ru.sug4chy.receipe_app.domain.list_allergens

import ru.sug4chy.receipe_app.data.database.entity.Allergen

interface ListAllergensUseCase {
    suspend operator fun invoke(): Result<List<Allergen>>
}