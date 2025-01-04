package ru.sug4chy.receipe_app.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel
import ru.sug4chy.receipe_app.data.model.Allergen
import ru.sug4chy.receipe_app.domain.list_allergens.ListAllergensUseCase

@KoinViewModel
class MainViewModel(
    private val listAllergensUseCase: ListAllergensUseCase
) : ViewModel() {

    private val _allergens: MutableLiveData<List<Allergen>> = MutableLiveData()
    val allergens: LiveData<List<Allergen>>
        get() = _allergens

    fun listAllergens() {
        viewModelScope.launch {
            listAllergensUseCase().also {
                if (it.isSuccess) {
                    _allergens.postValue(it.getOrThrow())
                }
            }
        }
    }
}