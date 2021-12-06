package br.com.cleanarchdictionary.data.remote.dto


import br.com.cleanarchdictionary.domain.model.Meaning
import com.google.gson.annotations.SerializedName

data class MeaningDto(
    @SerializedName("definitions")
    val definitions: List<DefinitionDto>?,
    @SerializedName("partOfSpeech")
    val partOfSpeech: String?
) {
    fun toMeaning() = Meaning(
        definitions = this.definitions?.map { it.toDefinition() } ?: emptyList(),
        partOfSpeech = this.partOfSpeech ?: ""
    )
}
