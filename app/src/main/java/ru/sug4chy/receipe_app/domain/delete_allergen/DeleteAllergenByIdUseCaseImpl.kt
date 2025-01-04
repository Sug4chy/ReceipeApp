package ru.sug4chy.receipe_app.domain.delete_allergen

import org.koin.core.annotation.Single
import ru.sug4chy.receipe_app.data.repository.allergens.AllergensRepository

@Single
class DeleteAllergenByIdUseCaseImpl(
    private val allergensRepository: AllergensRepository
) : DeleteAllergenByIdUseCase {

    override suspend fun invoke(id: Int) =
        allergensRepository.deleteById(id)
}