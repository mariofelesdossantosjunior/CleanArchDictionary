package br.com.cleanarchdictionary.domain.repository

import br.com.cleanarchdictionary.common.Resource
import br.com.cleanarchdictionary.domain.model.WordInfo
import kotlinx.coroutines.flow.Flow

interface WordInfoRepository {

    fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>>
}
