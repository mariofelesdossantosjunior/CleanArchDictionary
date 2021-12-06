package br.com.cleanarchdictionary.domain.usecase

import br.com.cleanarchdictionary.common.Resource
import br.com.cleanarchdictionary.domain.model.WordInfo
import br.com.cleanarchdictionary.domain.repository.WordInfoRepository
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
