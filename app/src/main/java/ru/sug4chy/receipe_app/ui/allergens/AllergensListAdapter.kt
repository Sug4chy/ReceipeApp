package ru.sug4chy.receipe_app.ui.allergens

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.sug4chy.receipe_app.data.model.Allergen
import ru.sug4chy.receipe_app.databinding.ViewholderAllergenBinding

class AllergensListAdapter(
    private val onDeleteAllergenBtnClicked: (Int) -> Unit
) : ListAdapter<Allergen, AllergensListAdapter.AllergenViewHolder>(AllergenDiffUtil()) {

    inner class AllergenViewHolder(
        private val binding: ViewholderAllergenBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(allergen: Allergen) {
            binding.allergenName.text = allergen.name
            binding.deleteAllergenBtn.setOnClickListener {
                onDeleteAllergenBtnClicked(allergen.id)
            }
        }
    }

    class AllergenDiffUtil : DiffUtil.ItemCallback<Allergen>() {

        override fun areItemsTheSame(oldItem: Allergen, newItem: Allergen): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Allergen, newItem: Allergen): Boolean =
            oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllergenViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        return AllergenViewHolder(
            binding = ViewholderAllergenBinding.inflate(
                inflater,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AllergenViewHolder, position: Int) =
        holder.bind(currentList[position])
}