package main

data class MediaType(
    val schema: Reference? = null,
    val example: Any? = null,
    val examples: Map<String, Reference>? = null,
    val encoding: Map<String, Encoding>? = null
)

class MediaTypeBuilder {
    private var schema: Reference? = null
    private var example: Any? = null
    private var examples: MutableMap<String, Reference>? = null
    private var encoding: MutableMap<String, Encoding>? = null

    fun build() = MediaType(schema, example, examples, encoding)
}
