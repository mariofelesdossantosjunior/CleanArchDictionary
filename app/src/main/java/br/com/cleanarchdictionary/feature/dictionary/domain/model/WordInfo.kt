package br.com.cleanarchdictionary.feature.dictionary.domain.model

data class WordInfo(
    val meaning: List<Meaning>,
    val origin: String,
    val phonetic: String,
    val word: String
)
