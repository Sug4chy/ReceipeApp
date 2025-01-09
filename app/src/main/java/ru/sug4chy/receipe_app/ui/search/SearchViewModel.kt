package ru.sug4chy.receipe_app.ui.search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel
import ru.sug4chy.receipe_app.domain.add_favourite.AddFavouriteUseCase
import ru.sug4chy.receipe_app.domain.list_recipes.ListRecipesByIngredientsUseCaseImpl
import ru.sug4chy.receipe_app.domain.list_recipes.ListRecipesUseCaseImpl
import ru.sug4chy.receipe_app.domain.list_recipes.Recipe

@KoinViewModel
class SearchViewModel(
    private val listRecipesByIngredientsUseCase: ListRecipesByIngredientsUseCaseImpl,
    private val listRecipesUseCase: ListRecipesUseCaseImpl,
    private val addFavouriteUseCase: AddFavouriteUseCase
) : ViewModel() {

    private var isLoading = false
    private val _recipes: MutableLiveData<List<Recipe>> = MutableLiveData()
    val recipes: LiveData<List<Recipe>>
        get() = _recipes

    fun listRecipes(searchQuery: String?) {
        viewModelScope.launch {
            val result = if (searchQuery.isNullOrEmpty()) {
                listRecipesUseCase.resetPages()
                listRecipesUseCase()
            } else {
                val ingredients = searchQuery.split(" ").filter { it.isNotBlank() }
                listRecipesByIngredientsUseCase.setIngredients(ingredients)
                listRecipesByIngredientsUseCase.resetPages()
                listRecipesByIngredientsUseCase()
            }
            _recipes.postValue(result)
        }
    }

    fun addFavourite(recipe: Recipe) {
        viewModelScope.launch {
            addFavouriteUseCase(
                recipe.name,
                recipe.cook_time,
                recipe.link,
                recipe.manual,
                recipe.category,
                recipe.ingredient
            )
        }
    }

    fun loadRecipes(searchQuery: String?) {
        if (isLoading) return
        isLoading = true
        viewModelScope.launch {
            val additionalRecipes = if (searchQuery.isNullOrEmpty()) {
                listRecipesUseCase()
            } else {
                listRecipesByIngredientsUseCase()
            }
            val currentList = _recipes.value ?: emptyList()
            _recipes.postValue(currentList + additionalRecipes)
            isLoading = false
        }
    }

}