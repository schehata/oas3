package main

data class Server(
    val url: String,
    val description: String? = null,
    val variables: Map<String, String>? = mapOf()
)

class ServerBuilder{
    private var url: String = "/"
    private var description: String? = null

    fun url(block: () -> String) { url = block() }
    fun description(block: () -> String) { description = block() }

    fun build() = Server(url, description)
}
