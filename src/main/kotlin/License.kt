package main


data class License(
    val name: String,
    val url: String? = null
)

class LicenseBuilder {
    var name: String = ""
    var url: String? = null

    fun build() = License(name, url)
}
