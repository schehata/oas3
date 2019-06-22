package main

@DslMarker annotation class InfoDSL

@InfoDSL
data class Info(
    val title: String,
    val description: String?,
    val termsOfService: String?,
    val contact: Contact?,
    val license: License?,
    val version: String
)


class InfoBuilder {
    private var title: String = ""
    private var description: String? = null
    private var termsOfService: String = ""
    private var contact: Contact? = null
    private var license: License? = null
    private var version: String = ""

    fun title(block: () -> String) {
        this.title = block()
    }

    fun description(block: () -> String) {
        this.description = block()
    }

    fun termsOfService(block: () -> String) {
        this.termsOfService = block()
    }

    fun contact(block: ContactBuilder.() -> Unit) {
        this.contact = ContactBuilder().apply(block).build()
    }

    fun license(block: LicenseBuilder.() -> Unit) {
        this.license = LicenseBuilder().apply(block).build()
    }

    fun version(block: () -> String) {
        this.version = block()
    }

    fun build() = Info(title, description, termsOfService, contact, license, version)
}

fun info(block: InfoBuilder.() -> Unit): Info {
    return InfoBuilder().apply(block).build()
}
