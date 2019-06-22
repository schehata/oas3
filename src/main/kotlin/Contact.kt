package main

data class Contact(
    val name: String? = null,
    val url: String? = null,
    val email: String? = null
)

class ContactBuilder {
    private var name: String? = null
    private var url: String? = null
    private var email: String? = null

    fun name(block: () -> String) {
        this.name = block()
    }

    fun url(block: () -> String) {
        this.url = block()
    }

    fun email(block: () -> String) {
        this.email = block()
    }

    fun build() = Contact(name, url, email)
}

fun contact(block: ContactBuilder.() -> Unit): Contact {
    return ContactBuilder().apply(block).build()
}
