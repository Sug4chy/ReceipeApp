package ru.sug4chy.receipe_app.ui.search

import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.sug4chy.receipe_app.R
import ru.sug4chy.receipe_app.databinding.FragmentFavoritesBinding
import ru.sug4chy.receipe_app.ui.favorites.FavoritesViewModel

class SearchFragment : Fragment(R.layout.fragment_favorites) {
    private val binding: FragmentFavoritesBinding by viewBinding()
    private val viewModel: SearchViewModel by viewModel()

    private val favouritesAdapter:
}