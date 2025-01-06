package ru.sug4chy.receipe_app.ui.favorites

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.sug4chy.receipe_app.R
import ru.sug4chy.receipe_app.databinding.FragmentFavoritesBinding

class FavoritesFragment : Fragment(R.layout.fragment_favorites) {

    private val binding: FragmentFavoritesBinding by viewBinding()
    private val viewModel: FavoritesViewModel by viewModel()

    private val favoritesAdapter: FavoritesListAdapter = FavoritesListAdapter(
        ::onIsFavoriteCheckboxUnselected
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.favoritesList.apply {
            this.adapter = this@FavoritesFragment.favoritesAdapter
            this.layoutManager = LinearLayoutManager(requireContext())
        }

        viewModel.recipes.observe(viewLifecycleOwner, favoritesAdapter::submitList)
        viewModel.listFavorites()
    }

    private fun onIsFavoriteCheckboxUnselected(id: Int) =
        viewModel.deleteFavoriteById(id)

}