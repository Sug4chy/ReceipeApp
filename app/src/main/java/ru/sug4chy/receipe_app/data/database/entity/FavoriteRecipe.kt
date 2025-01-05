package ru.sug4chy.receipe_app.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FavoriteRecipe(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    @ColumnInfo val name: String,
    @ColumnInfo(name = "cooking_time") val cookingTime: String,
    @ColumnInfo(name = "image_url") val imageURL: String
)