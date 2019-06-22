package main

data class SecurityRequirement(
    val name: String,
    val values: List<String>? = null
)

class SecurityRequirementBuilder {
    private var name = ""
    private var values: ArrayList<String> = arrayListOf()

    fun name(block: () -> String) { name = block() }
    fun value(block: () -> String) { values.add(block()) }

    fun build() = SecurityRequirement(name, values)
}
