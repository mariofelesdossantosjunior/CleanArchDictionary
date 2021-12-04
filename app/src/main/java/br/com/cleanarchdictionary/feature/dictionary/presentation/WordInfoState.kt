package br.com.cleanarchdictionary.feature.dictionary.presentation

import br.com.cleanarchdictionary.feature.dictionary.domain.model.WordInfo

data class WordInfoState(
    val wordInfoItems: List<WordInfo> = emptyList(),
    val isLoading: Boolean = false,
)
