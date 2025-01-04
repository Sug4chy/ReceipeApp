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
import ru.sug4chy.receipe_app.databinding.FragmentMainBinding
import ru.sug4chy.receipe_app.databinding.PopupAllergensBinding
import ru.sug4chy.receipe_app.ui.allergens.AllergensListAdapter

class MainFragment : Fragment(R.layout.fragment_main) {

    private val binding: FragmentMainBinding by viewBinding()
    private val viewModel: MainViewModel by viewModel()

    private val allergensAdapter: AllergensListAdapter = AllergensListAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val popupView = PopupAllergensBinding.inflate(layoutInflater, null, false)
        popupView.allergensList.apply {
            adapter = this@MainFragment.allergensAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        viewModel.allergens.observe(viewLifecycleOwner) {
            this@MainFragment.allergensAdapter.submitList(it)
        }
        viewModel.listAllergens()
        binding.root.post {
            PopupWindow(
                popupView.root,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                true
            ).showAtLocation(view, Gravity.CENTER, 0, 0)
        }
    }
}