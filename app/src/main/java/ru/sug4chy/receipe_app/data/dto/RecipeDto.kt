package ru.sug4chy.receipe_app.data.dto

import com.google.gson.annotations.SerializedName
import ru.sug4chy.receipe_app.domain.list_recipes.Recipe

data class RecipeDto (
    @SerializedName("name_dish") val name: String,
    @SerializedName("cook_time") val cookTime: String,
    @SerializedName("manual") val manual: String,
    @SerializedName("id") val id: Int,
    @SerializedName("ingredient") val ingredients: List<String>,
    @SerializedName("category") val categories: List<String>,
    @SerializedName("link") val links: List<String>
)

fun RecipeDto.toSchema(): Recipe {
    return Recipe(
        name = name,
        cook_time = cookTime,
        manual = manual,
        id = id,
        ingredient = ingredients.joinToString(", "),
        category = categories.joinToString(", "),
        link = links.firstOrNull() ?: ""
    )
}