package com.example.todo_app.di

import android.content.Context
import androidx.room.Room
import com.example.todo_app.repo.WorksDaoRepository
import com.example.todo_app.room.Database
import com.example.todo_app.room.WorksDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideWorksDaoRepository(idao:WorksDao) : WorksDaoRepository{
        return WorksDaoRepository(idao)
    }

    @Provides
    @Singleton
    fun provideKisilerDao(@ApplicationContext context: Context) : WorksDao {
        val vt = Room.databaseBuilder(context,
            Database::class.java,
            "to_do_works.sqlite").createFromAsset("to_do_works.sqlite").build()
        return vt.getWorksDao()
    }
}