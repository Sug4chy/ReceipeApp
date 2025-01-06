package ru.sug4chy.receipe_app.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_recipe")
data class FavoriteRecipe(
    @PrimaryKey val id: Int,
    val name: String,
    @ColumnInfo(name = "cooking_time") val cookingTime: String,
    @ColumnInfo(name = "image_url") val imageURL: String,
    val manual: String,
    val categories: String,
    val ingredients: String
)