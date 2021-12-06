package br.com.cleanarchdictionary.presentation.word_info

import br.com.cleanarchdictionary.domain.model.WordInfo

data class WordInfoState(
    val wordInfoItems: List<WordInfo> = emptyList(),
    val isLoading: Boolean = false,
)
