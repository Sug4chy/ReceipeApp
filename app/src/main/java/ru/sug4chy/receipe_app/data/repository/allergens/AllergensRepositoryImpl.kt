package ru.sug4chy.receipe_app.data.repository.allergens

import kotlinx.coroutines.delay
import org.koin.core.annotation.Single
import ru.sug4chy.receipe_app.data.model.Allergen

@Single
internal class AllergensRepositoryImpl : AllergensRepository {

    private val allergens: MutableList<Allergen> =
        mutableListOf(
            Allergen(1, "potato"),
            Allergen(2, "orange"),
            Allergen(3, "apple"),
            Allergen(4, "choco"),
        )

    override suspend fun findAll(): Result<List<Allergen>> {
        delay(1)
        return Result.success(allergens.toList())
    }
}