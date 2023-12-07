package com.hfad.allmusic.di

import android.content.Context
import com.hfad.allmusic.common.Constants
import com.hfad.allmusic.data.remote.ApiMusicInterface
import com.hfad.allmusic.data.repository.SongRepositoryImpl
import com.hfad.allmusic.domain.repository.SongRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesApiMusic(): ApiMusicInterface{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiMusicInterface::class.java)
    }

    @Provides
    @Singleton
    fun providesSongRepository(api: ApiMusicInterface): SongRepository{
        return SongRepositoryImpl(api)
    }


    @Provides
    @Singleton
    fun provideContext(@ApplicationContext context: Context): Context {
        return context
    }
}