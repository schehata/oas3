package main


data class License(
    val name: String,
    val url: String? = null
)

class LicenseBuilder {
    private var name: String = ""
    private var url: String? = null

    fun name(block: () -> String) {
        this.name = block()
    }

    fun url(block: () -> String) {
        this.url = block()
    }

    fun build() = License(name, url)
}

fun license(block: LicenseBuilder.() -> Unit): License {
    return LicenseBuilder().apply(block).build()
}
