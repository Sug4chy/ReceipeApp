package ru.sug4chy.receipe_app.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FavoriteRecipe(
    @PrimaryKey(autoGenerate = true) val id: Int?
)