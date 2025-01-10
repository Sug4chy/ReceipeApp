package ru.sug4chy.receipe_app.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil3.load
import ru.sug4chy.receipe_app.databinding.ViewholderFavoriteBinding
import ru.sug4chy.receipe_app.domain.list_recipes.Recipe

class SearchAdapter (
    private val onIsFavoriteCheckboxSelected: (Recipe) -> Unit,
    private val onRecipeClicked: (Recipe) -> Unit,
    private val onIsFavoriteCheckboxUnselected: (Int) -> Unit
) : ListAdapter<Recipe, SearchAdapter.SearchViewHolder>(FavoriteDiffUtil()) {

    inner class SearchViewHolder(
        private val binding: ViewholderFavoriteBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(recipe: Recipe) {
            binding.recipeTitle.text = recipe.name
            binding.cookingTime.text = recipe.cook_time
            binding.recipeImage.load(recipe.link)
            binding.isFavoriteCheckbox.isChecked = recipe.isFavourite
            binding.isFavoriteCheckbox.setOnCheckedChangeListener { _, isChecked ->
                if (!isChecked) {
                    onIsFavoriteCheckboxUnselected(recipe.id)
                } else {
                    onIsFavoriteCheckboxSelected(recipe)
                }
            }
            binding.categories.text = recipe.category
            binding.root.setOnClickListener {
                onRecipeClicked(recipe)
            }
        }
    }

    class FavoriteDiffUtil : DiffUtil.ItemCallback<Recipe>() {

        override fun areItemsTheSame(oldItem: Recipe, newItem: Recipe): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: Recipe,
            newItem: Recipe
        ): Boolean =
            oldItem == newItem

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        return SearchViewHolder(
            binding = ViewholderFavoriteBinding.inflate(
                inflater,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) =
        holder.bind(currentList[position])

}
