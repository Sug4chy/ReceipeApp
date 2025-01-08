package ru.sug4chy.receipe_app.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel
import ru.sug4chy.receipe_app.data.database.entity.FavoriteRecipe
import ru.sug4chy.receipe_app.domain.add_favourite.AddFavouriteUseCase
import ru.sug4chy.receipe_app.domain.list_recipes.ListRecipesUseCase
import ru.sug4chy.receipe_app.domain.list_recipes.Recipe

@KoinViewModel
class SearchViewModel(
    private val listRecipesUseCaseByCategory: ListRecipesUseCase,
    private val addFavouriteUseCase: AddFavouriteUseCase
) : ViewModel() {
    private val _recipes: MutableLiveData<List<Recipe>> = MutableLiveData()
    val recipes: LiveData<List<Recipe>>
        get() = _recipes

    fun listRecipes() {
        viewModelScope.launch {
            listRecipesUseCaseByCategory().also {
                _recipes.postValue(it)
            }
        }
    }

    fun addFavourite(recipe: FavoriteRecipe) {
        viewModelScope.launch {
            addFavouriteUseCase(
                recipe.name,
                recipe.cookingTime,
                recipe.imageURL,
                recipe.manual,
                recipe.categories,
                recipe.ingredients
            )
        }
    }
}