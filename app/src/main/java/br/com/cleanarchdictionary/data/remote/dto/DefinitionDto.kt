package br.com.cleanarchdictionary.data.remote.dto


import br.com.cleanarchdictionary.domain.model.Definition
import com.google.gson.annotations.SerializedName

data class DefinitionDto(
    @SerializedName("antonyms")
    val antonyms: List<String>?,
    @SerializedName("definition")
    val definition: String?,
    @SerializedName("example")
    val example: String?,
    @SerializedName("synonyms")
    val synonyms: List<String>?
) {
    fun toDefinition() = Definition(
        antonyms = this.antonyms ?: emptyList(),
        definition = this.definition ?: "",
        example = this.example,
        synonyms = this.synonyms ?: emptyList()
    )
}
