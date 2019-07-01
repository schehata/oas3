package main

data class Discriminator(
    val propertyName: String,
    val mapping: Map<String, String>?
)

class DiscriminatorBuilder {
    var propertyName = ""
    private var mapping: MutableMap<String, String>? = null

    fun map(key: String, value: String) {
        if (mapping == null) {
            mapping = mutableMapOf()
        }
    }

    fun build() = Discriminator(propertyName, mapping)
}
