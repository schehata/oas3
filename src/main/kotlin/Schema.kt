package main

import com.fasterxml.jackson.annotation.JsonProperty

data class Schema(
    val title: String?,
    val multipleOf: String?,
    val maximum: String?,
    val exclusiveMaximum: String?,
    val minimum: String?,
    val exclusiveMinimum: String?,
    val maxLength: String?,
    val minLength: String?,
    val pattern: String?,
    val maxItems: String?,
    val minItems: String?,
    val uniqueItems: String?,
    val maxProperties: String?,
    val minProperties: String?,
    val required: String?,
    val enum: String?,
    // Value MUST be a string. Multiple types via an array are not supported.
    val type: String?,
    // Inline or referenced schema MUST be of a Schema Object and not a standard JSON Schema.
    val allOf: Any?,
    // - Inline or referenced schema MUST be of a Schema Object and not a standard JSON Schema.
    val oneOf: Any?,
    // Inline or referenced schema MUST be of a Schema Object and not a standard JSON Schema.
    val anyOf: Any?,
    // Inline or referenced schema MUST be of a Schema Object and not a standard JSON Schema.
    @get:JsonProperty("not") val notField: Any?,
    // Value MUST be an object and not an array. Inline or referenced schema MUST be of
    // a Schema Object and not a standard JSON Schema. items MUST be present if the type is array.
    // Property definitions MUST be a Schema Object and not a standard JSON Schema (inline or referenced).
    val items: Map<String, Any>?,
    val properties: Any?,
    // Value can be boolean or object. Inline or referenced schema MUST be of a Schema Object
    // and not a standard JSON Schema. Consistent with JSON Schema, additionalProperties defaults to true.
    val additionalProperties: Any?,
    val description: String?,
    val format: SchemaFormat?,
    // The default value represents what would be assumed by the consumer of the input as the value of the schema
    // if one is not provided. Unlike JSON Schema, the value MUST conform to the defined type for the Schema Object
    // defined at the same level. For example, if type is string, then default can be "foo" but cannot be 1.
    val default: Any?,
    val nullable: Boolean? = false,
    val discriminator: Any?,
    val readOnly: Boolean? = false,
    val writeOnly: Boolean? = false,
    val xml: Any? = false,
    val externalDocs: ExternalDocumentation?,
    val example: Any?,
    val deprecated: Boolean? = false
): Referable()

enum class SchemaFormat {
    integer,
    number,
    string,
    boolean;
}

class SchemaBuilder : Referable() {
    var title: String? = null
    var multipleOf: String? = null
    var maximum: String? = null
    var exclusiveMaximum: String? = null
    var minimum: String? = null
    var exclusiveMinimum: String? = null
    var maxLength: String? = null
    var minLength: String? = null
    var pattern: String? = null
    var maxItems: String? = null
    var minItems: String? = null
    var uniqueItems: String? = null
    var maxProperties: String? = null
    var minProperties: String? = null
    var required: String? = null
    var enum: String? = null
    // Value MUST be a string. Multiple types via an array are not supported.
    var type: String? = null
    // Inline or referenced schema MUST be of a Schema Object and not a standard JSON Schema.
    var allOf: Any? = null
    // - Inline or referenced schema MUST be of a Schema Object and not a standard JSON Schema.
    var oneOf: Any? = null
    // Inline or referenced schema MUST be of a Schema Object and not a standard JSON Schema.
    var anyOf: Any? = null
    // Inline or referenced schema MUST be of a Schema Object and not a standard JSON Schema.
    @get:JsonProperty("not")
    var notField: Any? = null
    // Value MUST be an object and not an array. Inline or referenced schema MUST be of
    // a Schema Object and not a standard JSON Schema. items MUST be present if the type is array.
    // Property definitions MUST be a Schema Object and not a standard JSON Schema (inline or referenced).
    var items: Map<String, Any>? = null
    var properties: Any? = null
    // Value can be boolean or object. Inline or referenced schema MUST be of a Schema Object
    // and not a standard JSON Schema. Consistent with JSON Schema, additionalProperties defaults to true.
    var additionalProperties: Any? = null
    var description: String? = null
    var format: SchemaFormat? = null
    // The default value represents what would be assumed by the consumer of the input as the value of the schema
    // if one is not provided. Unlike JSON Schema, the value MUST conform to the defined type for the Schema Object
    // defined at the same level. For example, if type is string, then default can be "foo" but cannot be 1.
    var default: Any? = null
    var nullable: Boolean? = false
    private var discriminator: Discriminator? = null
    var readOnly: Boolean? = false
    var writeOnly: Boolean? = false
    private var xml: XML? = null
    private var externalDocs: ExternalDocumentation? = null
    var example: Any? = null
    var deprecated: Boolean? = false

    fun doc(block: ExternalDocumentationBuilder.() -> Unit) {
        externalDocs = ExternalDocumentationBuilder().apply(block).build()
    }

    fun discriminator(block: DiscriminatorBuilder.() -> Unit) {
        discriminator = DiscriminatorBuilder().apply(block).build()
    }

    fun xml(block: XMLBuilder.() -> Unit) {
        xml = XMLBuilder().apply(block).build()
    }

    fun build() = Schema(title, multipleOf, maximum, exclusiveMaximum, minimum, exclusiveMinimum, maxLength, minLength,
        pattern, maxItems, minItems, uniqueItems, maxProperties, minProperties, required, enum, type, allOf, oneOf,
        anyOf, notField, items, properties, additionalProperties, description, format, default, nullable, discriminator,
        readOnly, writeOnly, xml, externalDocs, example, deprecated)
}
