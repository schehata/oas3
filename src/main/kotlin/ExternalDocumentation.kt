package main

data class ExternalDocumentation(
    val url: String,
    val description: String? = null
)

class ExternalDocumentationBuilder {
    var url = ""
    var description: String? = null

    fun build() = ExternalDocumentation(url, description)
}
