package br.com.cleanarchdictionary.feature.dictionary.di

import android.app.Application
import androidx.room.Room
import br.com.cleanarchdictionary.feature.dictionary.data.local.Converters
import br.com.cleanarchdictionary.feature.dictionary.data.local.WordInfoDatabase
import br.com.cleanarchdictionary.feature.dictionary.data.remote.DictionaryApi
import br.com.cleanarchdictionary.feature.dictionary.data.repository.WordInfoRepositoryImpl
import br.com.cleanarchdictionary.feature.dictionary.data.util.GsonParser
import br.com.cleanarchdictionary.feature.dictionary.domain.repository.WordInfoRepository
import br.com.cleanarchdictionary.feature.dictionary.domain.usecase.GetWordInfo
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WordInfoModule {

    @Provides
    @Singleton
    fun provideGetWordInfoUseCase(repository: WordInfoRepository): GetWordInfo {
        return GetWordInfo(repository)
    }

    @Provides
    @Singleton
    fun provideWordInfoRepository(
        api: DictionaryApi,
        db: WordInfoDatabase
    ): WordInfoRepository {
        return WordInfoRepositoryImpl(api, db.dao)
    }

    @Provides
    @Singleton
    fun provideWordInfoDatabase(app: Application): WordInfoDatabase {
        return Room.databaseBuilder(
            app,
            WordInfoDatabase::class.java,
            "word_db"
        ).addTypeConverter(Converters(GsonParser(Gson())))
            .build()
    }

    @Provides
    @Singleton
    fun provideDictionaryApi(): DictionaryApi {
        return Retrofit.Builder()
            .baseUrl(DictionaryApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DictionaryApi::class.java)
    }
}
