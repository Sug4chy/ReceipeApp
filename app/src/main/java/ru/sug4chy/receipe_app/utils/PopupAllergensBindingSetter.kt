package ru.sug4chy.receipe_app.utils

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import ru.sug4chy.receipe_app.databinding.PopupAllergensBinding
import ru.sug4chy.receipe_app.ui.allergens.AllergensListAdapter

object PopupAllergensBindingSetter {

    fun setUp(
        binding: PopupAllergensBinding,
        adapter: AllergensListAdapter,
        context: Context,
        onAddBtnPressed: () -> Unit
    ): PopupAllergensBinding {
        binding.allergensList.apply {
            this.adapter = adapter
            this.layoutManager = LinearLayoutManager(context)
        }

        binding.addAllergenBtn.setOnClickListener {
            onAddBtnPressed()
        }

        return binding
    }
}