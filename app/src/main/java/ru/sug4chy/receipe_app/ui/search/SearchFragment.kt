package ru.sug4chy.receipe_app.ui.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.sug4chy.receipe_app.R
import ru.sug4chy.receipe_app.data.database.entity.FavoriteRecipe
import ru.sug4chy.receipe_app.databinding.FragmentFavoritesBinding
import ru.sug4chy.receipe_app.domain.list_recipes.Recipe

class SearchFragment : Fragment(R.layout.fragment_favorites) {
    private val binding: FragmentFavoritesBinding by viewBinding()
    private val viewModel: SearchViewModel by viewModel()

    private val searchAdapter: SearchAdapter = SearchAdapter(
        ::onIsFavoriteCheckboxSelected,
        ::onRecipeClicked
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.favoritesList.apply {
            this.adapter = this@SearchFragment.searchAdapter
            this.layoutManager = LinearLayoutManager(requireContext())
        }

        viewModel.recipes.observe(viewLifecycleOwner) { recipes ->
            searchAdapter.submitList(recipes)
        }
        val searchQuery = arguments?.getString("searchQuery")
        viewModel.listRecipes(searchQuery)

        binding.favoritesList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val totalItemCount = layoutManager.itemCount
                val lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition()

                if (lastVisibleItemPosition >= totalItemCount - 1) {
                    viewModel.loadRecipes(searchQuery)
                }
            }
        })
    }

    private fun onIsFavoriteCheckboxSelected(recipe: Recipe) =
        viewModel.addFavourite(recipe)

    private fun onRecipeClicked(recipe: Recipe) {
        val favouriteRecipe = FavoriteRecipe(
            id = recipe.id,
            name = recipe.name,
            cookingTime = recipe.cook_time,
            imageURL = recipe.link,
            manual = recipe.manual,
            categories = recipe.category,
            ingredients = recipe.ingredient
        )
        val action = SearchFragmentDirections.actionSearchFragmentToRecipeFragment(favouriteRecipe)
        findNavController().navigate(action)
    }
}