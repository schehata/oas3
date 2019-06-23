package main

data class Contact(
    val name: String? = null,
    val url: String? = null,
    val email: String? = null
)

class ContactBuilder {
    var name: String? = null
    var url: String? = null
    var email: String? = null

    fun build() = Contact(name, url, email)
}
