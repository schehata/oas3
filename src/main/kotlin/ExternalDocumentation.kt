package main

data class ExternalDocumentation(
    val url: String,
    val description: String? = null
)

class ExternalDocumentationBuilder {
    private var url = ""
    private var description: String? = null

    fun url(block: () -> String) { url = block() }
    fun description(block: () -> String) { description = block() }

    fun build() = ExternalDocumentation(url, description)
}
