package ru.sug4chy.receipe_app.ui.recipe

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import coil3.load
import ru.sug4chy.receipe_app.R
import ru.sug4chy.receipe_app.data.database.entity.FavoriteRecipe
import ru.sug4chy.receipe_app.databinding.FragmentRecipeBinding

class RecipeFragment : Fragment(R.layout.fragment_recipe) {

    private val binding: FragmentRecipeBinding by viewBinding()
    private val args: RecipeFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUp(args.recipe ?: return)
    }

    private fun setUp(recipe: FavoriteRecipe) {
        binding.recipeImage.load(recipe.imageURL)
        binding.recipeName.text = recipe.name
        binding.recipeIngredients.text = recipe.ingredients
        binding.recipeManual.text = recipe.manual.replace("\\n\\n", "\n\n")
        binding.recipeManual.movementMethod = ScrollingMovementMethod()
        binding.recipeCategories.text = recipe.categories
    }
}