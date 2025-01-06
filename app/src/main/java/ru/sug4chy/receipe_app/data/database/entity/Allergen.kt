package ru.sug4chy.receipe_app.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Allergen(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    val name: String
) {
    companion object {

        fun withName(name: String): Allergen =
            Allergen(
                id = null,
                name = name
            )
    }
}