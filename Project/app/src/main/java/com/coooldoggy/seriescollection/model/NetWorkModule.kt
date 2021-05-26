package com.coooldoggy.seriescollection.model

import com.coooldoggy.seriescollection.BASE_API_URL
import com.coooldoggy.seriescollection.BuildConfig
import com.coooldoggy.seriescollection.model.api.BrowseApiHelper
import com.coooldoggy.seriescollection.model.api.BrowseApiService
import com.coooldoggy.seriescollection.model.api.BrowseApiServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetWorkModule {

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_API_URL)
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit) = retrofit.create(BrowseApiService::class.java)

    @Provides
    @Singleton
    fun provideApiHelper(browseApiServiceImpl: BrowseApiServiceImpl): BrowseApiHelper = browseApiServiceImpl

    @Singleton
    @Provides
    fun provideOkHttpClient() = if (BuildConfig.DEBUG){
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }else{
        OkHttpClient
            .Builder()
            .build()
    }
}