package main

import com.fasterxml.jackson.annotation.JsonProperty

data class Parameter(
    val name: String,
    @get:JsonProperty("in") val inField: ParameterLocation,
    val description: String? = null,
    val required: Boolean? = false,
    val deprecated: Boolean? = false,
    val allowEmptyValue: Boolean? = false,
    val style: ParameterStyle? = null,
    val explode: Boolean? = false,
    val allowReserved: Boolean? = false,
    val schema: Any? = null,
    val example: Any? = null,
    val examples: Map<String, Reference>? = null,
    val content: Map<String, MediaType>? = null
) : Referable()

enum class ParameterLocation {
    path,
    query,
    header,
    cookie;
}

enum class ParameterStyle {
    matrix,
    label,
    form,
    simple,
    spaceDelimited,
    pipeDelimited,
    deepObject;
}

class ParameterBuilder : Referable() {
    var name: String = ""
    var `in`: ParameterLocation = ParameterLocation.path
    var description: String? = null
    var required: Boolean? = false
    var deprecated: Boolean? = false
    var allowEmptyValue: Boolean? = false
    var style: ParameterStyle? = null
    var explode: Boolean? = false
    var allowReserved: Boolean? = false
    private var schema: Referable? = null
    private var example: Any? = null
    private var examples: MutableMap<String, Reference>? = null
    private var content: MutableMap<String, MediaType>? = null

    fun schema(block: SchemaBuilder.() -> Unit) {
        schema = SchemaBuilder().apply(block).build()
    }

    fun content(scheme: String, block: MediaTypeBuilder.() -> Unit) {
        if (content == null) {
            content = mutableMapOf()
        }
        content!![scheme] = MediaTypeBuilder().apply(block).build()
    }

    fun build() = Parameter(name, `in`, description, required, deprecated, allowEmptyValue, style, explode,
        allowReserved, schema, example, examples, content)
}
