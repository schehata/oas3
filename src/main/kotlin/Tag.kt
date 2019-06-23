package main

data class Tag(
    val name: String,
    val description: String? = null,
    val externalDocs: ExternalDocumentation? = null
)

class TagBuilder {
    private var name: String = ""
    private var description: String? = null
    private var externalDocs: ExternalDocumentation? = null

    fun name(block: () -> String) { name = block() }
    fun description(block: () -> String) { description = block() }
    fun doc(block: ExternalDocumentationBuilder.() -> Unit) {
        externalDocs = ExternalDocumentationBuilder().apply(block).build()
    }

    fun build() = Tag(name, description, externalDocs)
}
