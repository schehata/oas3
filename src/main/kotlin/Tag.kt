package main

data class Tag(
    val name: String,
    val description: String? = null,
    val externalDocs: ExternalDocumentation? = null
)

class TagBuilder {
    var name: String = ""
    var description: String? = null
    private var externalDocs: ExternalDocumentation? = null

    fun doc(block: ExternalDocumentationBuilder.() -> Unit) {
        externalDocs = ExternalDocumentationBuilder().apply(block).build()
    }

    fun build() = Tag(name, description, externalDocs)
}
