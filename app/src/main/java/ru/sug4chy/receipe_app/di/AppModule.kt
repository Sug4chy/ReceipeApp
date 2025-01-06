package ru.sug4chy.receipe_app.di

import androidx.room.Room
import org.koin.android.ext.koin.androidApplication
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.dsl.module
import ru.sug4chy.receipe_app.data.database.AppDatabase
import ru.sug4chy.receipe_app.data.database.dao.AllergensDao
import ru.sug4chy.receipe_app.data.database.dao.FavoriteRecipesDao

@Module
@ComponentScan("ru.sug4chy.receipe_app")
class AppModule

val appModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            AppDatabase::class.java,
            "app_database"
        ).build()
    }
    single<AllergensDao> {
        get<AppDatabase>().allergensDao()
    }
    single<FavoriteRecipesDao> {
        get<AppDatabase>().favoriteRecipesDao()
    }
}