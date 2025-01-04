package ru.sug4chy.receipe_app.domain.add_allergen

interface AddAllergenUseCase {
    suspend operator fun invoke(name: String)
}