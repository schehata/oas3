package main

data class Info(
    val title: String,
    val description: String?,
    val termsOfService: String?,
    val contact: Contact?,
    val license: License?,
    val version: String
)

class InfoBuilder {
    var title: String = ""
    var description: String? = null
    var termsOfService: String? = null
    private var contact: Contact? = null
    private var license: License? = null
    var version: String = ""

    fun contact(block: ContactBuilder.() -> Unit) {
        this.contact = ContactBuilder().apply(block).build()
    }

    fun license(block: LicenseBuilder.() -> Unit) {
        this.license = LicenseBuilder().apply(block).build()
    }

    fun build() = Info(title, description, termsOfService, contact, license, version)
}
