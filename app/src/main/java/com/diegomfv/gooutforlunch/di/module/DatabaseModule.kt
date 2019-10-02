package com.diegomfv.gooutforlunch.di.module

import dagger.Module


@Module
class DatabaseModule {

    @Module
    companion object {

//        @Singleton
//        @Provides
//        @JvmStatic
//        @Named(MONGO_COLLECTION_SENTENCE)
//        fun provideSentenceCollection (mongoDB: MongoDB) : MongoCollection<Document> {
//            return mongoDB.getCollectionItem()
//        }
//
//        @Singleton
//        @Provides
//        @JvmStatic
//        @Named(MONGO_COLLECTION_SENTENCE)
//        fun provideSentenceMongoDBHelper(
//            @Named(MONGO_COLLECTION_SENTENCE) mongoCollection: MongoCollection<Document>,
//            gson: Gson
//        ): MongoDBHelper {
//            return MongoDBHelper(mongoCollection, gson)
//        }
//
//        @Singleton
//        @Provides
//        @JvmStatic
//        @Named(MONGO_COLLECTION_GUESS)
//        fun provideGuessCollection (mongoDB: MongoDB) : MongoCollection<Document> {
//            return mongoDB.getCollectionGuess()
//        }
//
//        @Singleton
//        @Provides
//        @JvmStatic
//        @Named(MONGO_COLLECTION_GUESS)
//        fun provideGuessMongoDBHelper(
//            @Named(MONGO_COLLECTION_GUESS) mongoCollection: MongoCollection<Document>,
//            gson: Gson
//        ): MongoDBHelper {
//            return MongoDBHelper(mongoCollection, gson)
//        }
    }
}