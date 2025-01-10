package ru.sug4chy.receipe_app.data.dto

import com.google.gson.annotations.SerializedName
import ru.sug4chy.receipe_app.domain.list_recipes.Recipe

data class RecipeDto(
    @SerializedName("name_dish") val name: String,
    @SerializedName("cook_time") val cookTime: String,
    @SerializedName("manual") val manual: String,
    @SerializedName("id") val id: Int,
    @SerializedName("ingredient") val ingredients: List<IngredientDto>,
    @SerializedName("category") val categories: List<CategoryDto>,
    @SerializedName("link") val link: LinkDto
)

data class IngredientDto(
    @SerializedName("name_ingr") val nameIngr: String
)

data class LinkDto(
    @SerializedName("photo") val photo: String
)

data class CategoryDto(
    @SerializedName("name_cat") val nameCat: String
)

fun RecipeDto.toSchema(isFavourite: Boolean = false): Recipe {
    return Recipe(
        isFavourite = isFavourite,
        name = name,
        cook_time = cookTime,
        manual = manual,
        id = id,
        ingredient = ingredients.joinToString { it.nameIngr },
        category = categories.joinToString { it.nameCat },
        link = link.photo
    )
}