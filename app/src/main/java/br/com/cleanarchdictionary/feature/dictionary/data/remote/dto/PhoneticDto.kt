package br.com.cleanarchdictionary.feature.dictionary.data.remote.dto


import com.google.gson.annotations.SerializedName

data class PhoneticDto(
    @SerializedName("audio")
    val audio: String?,
    @SerializedName("text")
    val text: String?
)
