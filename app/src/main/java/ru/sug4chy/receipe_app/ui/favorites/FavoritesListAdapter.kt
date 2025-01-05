package ru.sug4chy.receipe_app.ui.favorites

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.sug4chy.receipe_app.data.database.entity.FavoriteRecipe
import ru.sug4chy.receipe_app.databinding.ViewholderFavoriteBinding

class FavoritesListAdapter(

) : ListAdapter<FavoriteRecipe, FavoritesListAdapter.FavoriteViewHolder>(FavoriteDiffUtil()) {

    class FavoriteViewHolder(
        private val binding: ViewholderFavoriteBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(recipe: FavoriteRecipe) {

        }
    }

    class FavoriteDiffUtil : DiffUtil.ItemCallback<FavoriteRecipe>() {

        override fun areItemsTheSame(oldItem: FavoriteRecipe, newItem: FavoriteRecipe): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: FavoriteRecipe,
            newItem: FavoriteRecipe
        ): Boolean =
            oldItem == newItem

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        return FavoriteViewHolder(
            binding = ViewholderFavoriteBinding.inflate(
                inflater,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) =
        holder.bind(currentList[position])
}