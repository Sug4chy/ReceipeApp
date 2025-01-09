package ru.sug4chy.receipe_app.domain.delete_favorite

interface DeleteFavoriteByIdUseCase {
    suspend operator fun invoke(id: Int)
}