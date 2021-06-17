package dev.darshn.trektrak.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.darshn.trektrak.db.RunDatabase
import dev.darshn.trektrak.util.Constants
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRunDatabase(
        @ApplicationContext app:Context
    ) :RunDatabase {

     return   Room.databaseBuilder(
            app,
            RunDatabase::class.java,
            Constants.RUN_DB_NAME
        ).build()

    }

    @Singleton
    @Provides
    fun provideRunDao(db:RunDatabase) = db.getRunDao()
}