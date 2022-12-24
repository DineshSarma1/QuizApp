package com.dinesh.quizappassignment7.di

import android.app.Application
import androidx.room.Room
import com.dinesh.quizappassignment7.constants.Constant.DB_NAME
import com.dinesh.quizappassignment7.repository.QuizRepository
import com.dinesh.quizappassignment7.repository.QuizRepositoryImpl
import com.dinesh.quizappassignment7.database.QuizDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideQuizDatabase(context: Application) : QuizDatabase {
        return Room.databaseBuilder(
            context,
            QuizDatabase::class.java,
            DB_NAME
        ).build()
    }

    @Singleton
    @Provides
    fun provideQuizRepository(db: QuizDatabase) : QuizRepository {
        return QuizRepositoryImpl(db)
    }

 }