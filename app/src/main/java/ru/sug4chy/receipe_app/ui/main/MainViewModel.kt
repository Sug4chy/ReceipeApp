package ru.sug4chy.receipe_app.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel
import ru.sug4chy.receipe_app.data.database.entity.Allergen
import ru.sug4chy.receipe_app.domain.add_allergen.AddAllergenUseCase
import ru.sug4chy.receipe_app.domain.delete_allergen.DeleteAllergenByIdUseCase
import ru.sug4chy.receipe_app.domain.list_allergens.ListAllergensUseCase

@KoinViewModel
class MainViewModel(
    private val listAllergensUseCase: ListAllergensUseCase,
    private val addAllergenUseCase: AddAllergenUseCase,
    private val deleteAllergenByIdUseCase: DeleteAllergenByIdUseCase
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

    fun addAllergen(name: String) {
        viewModelScope.launch {
            addAllergenUseCase(name)
            listAllergens()
        }
    }

    fun deleteAllergenById(id: Int) {
        viewModelScope.launch {
            deleteAllergenByIdUseCase(id)
            listAllergens()
        }
    }
}