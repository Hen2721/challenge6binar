package com.hen.book.di

import android.content.Context
import androidx.work.WorkManager
import com.hen.data.data.PlayerRepository
import com.hen.data.data.UserRepository
import com.hen.data.domain.usecase.PlayerInteractor
import com.hen.data.domain.usecase.PlayerUseCase
import com.hen.data.domain.usecase.UserInteractor
import com.hen.data.domain.usecase.UserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePlayerUseCase(playerRepository: PlayerRepository): PlayerUseCase = PlayerInteractor(playerRepository)

    @Provides
    @Singleton
    fun provideUserUseCase(userRepository: UserRepository): UserUseCase = UserInteractor(userRepository)

    @Singleton
    @Provides
    fun provideWorkManager(context: Context): WorkManager {
        return WorkManager.getInstance(context)
    }

    @Singleton
    @Provides
    fun provideContext(@ApplicationContext context: Context): Context {
        return context
    }
}