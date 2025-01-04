package ru.sug4chy.receipe_app.data.repository.allergens

import org.koin.core.annotation.Provided
import org.koin.core.annotation.Single
import ru.sug4chy.receipe_app.data.database.dao.AllergensDao
import ru.sug4chy.receipe_app.data.database.entity.Allergen

@Single
internal class AllergensRepositoryImpl(
    @Provided private val allergensDao: AllergensDao
) : AllergensRepository {

    override suspend fun findAll(): Result<List<Allergen>> =
        try {
            Result.success(allergensDao.findAll())
        } catch (ex: Exception) {
            Result.failure(ex)
        }

    override suspend fun add(name: String) {
        allergensDao.save(Allergen.withName(name))
    }

    override suspend fun deleteById(id: Int) {
        allergensDao.deleteById(id)
    }
}