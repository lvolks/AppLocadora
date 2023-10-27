package dev.volks.applocadora

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.volks.applocadora.data.FilmeDao
import dev.volks.applocadora.data.FilmeRepository
import dev.volks.applocadora.data.FilmeRepositorySQLite
import dev.volks.applocadora.data.SQLite
import javax.inject.Singleton

//APLICAÇÃO APPLOCADORA UTILIZANDO HILT
@Module
@HiltAndroidApp
@InstallIn(SingletonComponent::class)
class AppLocadora : Application() {

        @Provides
        fun provideFilmeRepository(repositorySQLite: FilmeRepositorySQLite): FilmeRepository {
            return repositorySQLite
        }

        @Provides
        fun provideFilmeDao(banco: SQLite): FilmeDao {
            return banco.filmeDao()
        }

        @Provides
        @Singleton
        fun provideBanco(@ApplicationContext ctx: Context): SQLite {
            return SQLite.get(ctx)
        }

    }
