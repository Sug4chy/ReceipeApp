package ru.sug4chy.receipe_app.ui.main

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.PopupWindow
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.sug4chy.receipe_app.R
import ru.sug4chy.receipe_app.data.model.Allergen
import ru.sug4chy.receipe_app.databinding.FragmentMainBinding
import ru.sug4chy.receipe_app.databinding.PopupAllergensBinding
import ru.sug4chy.receipe_app.ui.allergens.AllergensListAdapter
import ru.sug4chy.receipe_app.utils.PopupAllergensBindingSetter

class MainFragment : Fragment(R.layout.fragment_main) {

    private val binding: FragmentMainBinding by viewBinding()
    private val viewModel: MainViewModel by viewModel()
    private val popupBinding by lazy {
        PopupAllergensBindingSetter.setUp(
            binding = PopupAllergensBinding.inflate(layoutInflater, null, false),
            adapter = allergensAdapter,
            context = requireContext(),
            onAddBtnPressed = ::onAddAllergenBtnClicked
        )
    }

    private val allergensAdapter: AllergensListAdapter = AllergensListAdapter(::onDeleteAllergenBtnClicked)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.allergens.observe(viewLifecycleOwner, ::onAllergensListed)
        viewModel.listAllergens()

        binding.root.post {
            PopupWindow(
                popupBinding.root,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                true
            ).showAtLocation(view, Gravity.CENTER, 0, 0)
        }
    }

    private fun onAllergensListed(allergens: List<Allergen>) =
        this@MainFragment.allergensAdapter.submitList(allergens)

    private fun onAddAllergenBtnClicked() {
        val enteredName = popupBinding.addAllergenTextField.text.toString()
        popupBinding.addAllergenTextField.text.clear()

        viewModel.addAllergen(enteredName)
    }

    private fun onDeleteAllergenBtnClicked(id: Int) =
        viewModel.deleteAllergenById(id)
}