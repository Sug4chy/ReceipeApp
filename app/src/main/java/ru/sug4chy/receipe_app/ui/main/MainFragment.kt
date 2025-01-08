package ru.sug4chy.receipe_app.ui.main

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.PopupWindow
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.sug4chy.receipe_app.R
import ru.sug4chy.receipe_app.data.database.entity.Allergen
import ru.sug4chy.receipe_app.databinding.FragmentMainBinding
import ru.sug4chy.receipe_app.databinding.PopupAllergensBinding
import ru.sug4chy.receipe_app.ui.allergens.AllergensListAdapter

class MainFragment : Fragment(R.layout.fragment_main) {

    private val binding: FragmentMainBinding by viewBinding()
    private val viewModel: MainViewModel by viewModel()
    private val popupBinding by lazy { setUpPopupAllergensBinding() }

    private val allergensAdapter: AllergensListAdapter =
        AllergensListAdapter(::onDeleteAllergenBtnClicked)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.allergens.observe(viewLifecycleOwner, ::onAllergensListed)
        viewModel.listAllergens()
    }

    private fun setUpPopupAllergensBinding(): PopupAllergensBinding {
        val binding = PopupAllergensBinding.inflate(layoutInflater, null, false)
        binding.allergensList.apply {
            this.adapter = this@MainFragment.allergensAdapter
            this.layoutManager = LinearLayoutManager(context)
        }

        binding.addAllergenBtn.setOnClickListener {
            onAddAllergenBtnClicked(
                popupBinding = binding
            )
        }

        return binding
    }

    private fun onAllergensListed(allergens: List<Allergen>) =
        this@MainFragment.allergensAdapter.submitList(allergens)

    private fun onAddAllergenBtnClicked(
        popupBinding: PopupAllergensBinding
    ) {
        val enteredName = popupBinding.addAllergenTextField.text.toString()
        popupBinding.addAllergenTextField.text.clear()
        popupBinding.addAllergenTextField.clearFocus()

        viewModel.addAllergen(enteredName)
    }

    private fun onDeleteAllergenBtnClicked(id: Int) =
        viewModel.deleteAllergenById(id)

    // Вызывать при нажатии на кнопку "Food allergens", когда нужно будет показать всплывающее окно
    private fun showAllergensPopup() {
        PopupWindow(
            popupBinding.root,
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT,
            true
        ).also {
            it.showAtLocation(view, Gravity.CENTER, 0, 0)
            it.setOnDismissListener { binding.root.alpha = 1.0F }
            binding.root.alpha = 0.7F
        }
    }
}