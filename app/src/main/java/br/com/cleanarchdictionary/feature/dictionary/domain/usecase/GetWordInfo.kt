package br.com.cleanarchdictionary.feature.dictionary.domain.usecase

import br.com.cleanarchdictionary.core.util.Resource
import br.com.cleanarchdictionary.feature.dictionary.domain.model.WordInfo
import br.com.cleanarchdictionary.feature.dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetWordInfo(
    private val repository: WordInfoRepository
) {

    operator fun invoke(word: String): Flow<Resource<List<WordInfo>>> {
        if (word.isBlank()) {
            return flow { }
        }
        return repository.getWordInfo(word)
    }
}
