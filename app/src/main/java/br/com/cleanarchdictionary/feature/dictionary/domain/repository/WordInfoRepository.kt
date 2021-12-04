package br.com.cleanarchdictionary.feature.dictionary.domain.repository

import br.com.cleanarchdictionary.core.util.Resource
import br.com.cleanarchdictionary.feature.dictionary.domain.model.WordInfo
import kotlinx.coroutines.flow.Flow

interface WordInfoRepository {

    fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>>
}
