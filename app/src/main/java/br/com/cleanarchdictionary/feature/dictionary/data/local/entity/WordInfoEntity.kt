package br.com.cleanarchdictionary.feature.dictionary.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.cleanarchdictionary.feature.dictionary.domain.model.Meaning
import br.com.cleanarchdictionary.feature.dictionary.domain.model.WordInfo

@Entity
data class WordInfoEntity(
    val word: String,
    val phonetic: String,
    val origin: String,
    val meanings: List<Meaning>,
    @PrimaryKey val id: Int? = null
) {
    fun toWordInfo() = WordInfo(
        meaning = this.meanings,
        word = this.word,
        phonetic = this.phonetic,
        origin = this.origin
    )
}
