package ru.sug4chy.receipe_app.domain.add_allergen

import org.koin.core.annotation.Single
import ru.sug4chy.receipe_app.data.repository.allergens.AllergensRepository

@Single
internal class AddAllergenUseCaseImpl(
    private val allergensRepository: AllergensRepository
) : AddAllergenUseCase {

    override suspend fun invoke(name: String) =
        allergensRepository.add(name)
}