package main

data class Server(
    val url: String,
    val description: String? = null,
    val variables: Map<String, String>? = mapOf()
)

class ServerBuilder{
    var url: String = "/"
    var description: String? = null

    fun build() = Server(url, description)
}
