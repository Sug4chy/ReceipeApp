package ru.sug4chy.receipe_app.ui.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel
import ru.sug4chy.receipe_app.data.database.entity.FavoriteRecipe
import ru.sug4chy.receipe_app.domain.delete_favorite.DeleteFavoriteByIdUseCase
import ru.sug4chy.receipe_app.domain.list_favorites.ListFavoritesUseCase

@KoinViewModel
class FavoritesViewModel(
    private val listFavoritesUseCase: ListFavoritesUseCase,
    private val deleteFavoriteByIdUseCase: DeleteFavoriteByIdUseCase,
) : ViewModel() {

    private val _recipes: MutableLiveData<List<FavoriteRecipe>> = MutableLiveData()
    val recipes: LiveData<List<FavoriteRecipe>>
        get() = _recipes

    fun listFavorites() {
        viewModelScope.launch {
            listFavoritesUseCase().also {
                _recipes.postValue(it)
            }
        }
    }

    fun deleteFavoriteById(id: Int) {
        viewModelScope.launch {
            deleteFavoriteByIdUseCase(id)
            listFavorites()
        }
    }
}