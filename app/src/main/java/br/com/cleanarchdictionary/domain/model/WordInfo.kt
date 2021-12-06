package br.com.cleanarchdictionary.domain.model

data class WordInfo(
    val meaning: List<Meaning>,
    val origin: String,
    val phonetic: String,
    val word: String
)
