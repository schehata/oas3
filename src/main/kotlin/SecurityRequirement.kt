package main

data class SecurityRequirement(
    val scheme: String,
    val scopes: List<String>? = null
)

class SecurityRequirementBuilder {
    private var scheme = ""
    private var scopes: MutableList<String>? = null

    fun scheme(block: () -> String) { scheme = block() }
    fun scopes(block: () -> String) {
        if (scopes == null) {
            scopes = mutableListOf()
        }
        scopes!!.add(block())
    }

    fun build() = SecurityRequirement(scheme, scopes)
}
