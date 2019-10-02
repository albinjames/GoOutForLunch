package com.diegomfv.gooutforlunch.di.module

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
abstract class NetworkModule {

    @Module
    companion object {

        @Singleton
        @Provides
        @JvmStatic
        fun provideGsonConverterFactory(): GsonConverterFactory {
            return GsonConverterFactory.create()
        }

        @Singleton
        @Provides
        @JvmStatic
        fun provideRxJava2CallAdapterFactory(): RxJava2CallAdapterFactory {
            return RxJava2CallAdapterFactory.create()
        }

        @Singleton
        @Provides
        @JvmStatic
        fun provideOkHttpClient(): OkHttpClient {
            return OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .addInterceptor { interceptorChain ->
                    val original = interceptorChain.request()

                    //Request for authentication: add request headers
                    val requestBuilder = original.newBuilder()
//                        .header("UserModel-Agent", "application/alloy-mobile////")
//                        .header("token", SESSION_TOKEN)
                        .method(original.method(), original.body())

                    val request = requestBuilder.build()
                    Timber.w("Request: ${request.url()}")
                    val response = interceptorChain.proceed(request)
                    Timber.w("Response: ${response.message()}")
                    response
                }.build()
        }

//        @Singleton
//        @Provides
//        @JvmStatic
//        fun provideFixerRetrofit (
//            gsonConverterFactory: GsonConverterFactory,
//            rxJava2CallAdapterFactory: RxJava2CallAdapterFactory,
//            okHttpClient: OkHttpClient)
//                : Retrofit {
//            return Retrofit.Builder()
//                .baseUrl(BASE_FIXER_URL)
//                .addConverterFactory(gsonConverterFactory)
//                .addCallAdapterFactory(rxJava2CallAdapterFactory)
//                .client(okHttpClient)
//                .build()
//        }
//
//        @Singleton
//        @Provides
//        @JvmStatic
//        fun provideFixerEndpoints (retrofit: Retrofit) : FixerEndpoints {
//            return retrofit.create(FixerEndpoints::class.java)
//        }
    }
}