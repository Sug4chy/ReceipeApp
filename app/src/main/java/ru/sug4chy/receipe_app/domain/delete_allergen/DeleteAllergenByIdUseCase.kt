package ru.sug4chy.receipe_app.domain.delete_allergen

interface DeleteAllergenByIdUseCase {
    suspend operator fun invoke(id: Int)
}