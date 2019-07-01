package main

data class XML(
    val name: String?,
    val namespace: String?,
    val prefix: String?,
    val attribute: Boolean? = false,
    val wrapped: Boolean? = false
)

class XMLBuilder {
    var name: String? = null
    var namespace: String? = null
    var prefix: String? = null
    var attribute: Boolean? = false
    var wrapped: Boolean? = false

    fun build() = XML(name, namespace, prefix, attribute, wrapped)
}
