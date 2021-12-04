package br.com.cleanarchdictionary.feature.dictionary.data.remote.dto


import br.com.cleanarchdictionary.feature.dictionary.data.local.entity.WordInfoEntity
import com.google.gson.annotations.SerializedName

data class WordInfoDto(
    @SerializedName("meanings")
    val meanings: List<MeaningDto>?,
    @SerializedName("origin")
    val origin: String?,
    @SerializedName("phonetic")
    val phonetic: String?,
    @SerializedName("phonetics")
    val phonetics: List<PhoneticDto>?,
    @SerializedName("word")
    val word: String?
) {
    fun toWordInfoEntity() = WordInfoEntity(
        meanings = this.meanings?.map { it.toMeaning() } ?: emptyList(),
        origin = this.origin ?: "",
        phonetic = this.phonetic ?: "",
        word = this.word ?: ""
    )

}
