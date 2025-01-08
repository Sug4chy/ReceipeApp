package ru.sug4chy.receipe_app.di

import androidx.room.Room
import org.koin.android.ext.koin.androidApplication
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.sug4chy.receipe_app.data.api.ApiService
import ru.sug4chy.receipe_app.data.database.AppDatabase
import ru.sug4chy.receipe_app.data.database.dao.AllergensDao
import ru.sug4chy.receipe_app.data.database.dao.FavoriteRecipesDao
import ru.sug4chy.receipe_app.domain.list_recipes.ListRecipesByIngredientsUseCaseImpl
import ru.sug4chy.receipe_app.domain.list_recipes.ListRecipesUseCase
import ru.sug4chy.receipe_app.domain.list_recipes.ListRecipesUseCaseImpl

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

val networkModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("http://94.159.103.68:5000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<ApiService> {
        get<Retrofit>().create(ApiService::class.java)
    }
}