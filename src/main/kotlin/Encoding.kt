package main

data class Encoding(
    val contentType: String? = null,
    val headers: Map<String, Reference>? = null,
    val style: String? = null,
    val explode: Boolean? = false,
    val allowReserved: Boolean? = false
)

class EncodingBuilder {
    var contentType: String? = null
    var headers: Map<String, Reference>? = null
    var style: String? = null
    var explode: Boolean? = false
    var allowReserved: Boolean? = false

    fun build() = Encoding(contentType, headers, style, explode, allowReserved)
}
