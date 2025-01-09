package ru.sug4chy.receipe_app.domain.list_allergens

import org.koin.core.annotation.Single
import ru.sug4chy.receipe_app.data.database.entity.Allergen
import ru.sug4chy.receipe_app.data.repository.allergens.AllergensRepository

@Single
internal class ListAllergensUseCaseImpl(
    private val repository: AllergensRepository
) : ListAllergensUseCase {

    override suspend fun invoke(): List<Allergen> =
        repository.findAll()
}