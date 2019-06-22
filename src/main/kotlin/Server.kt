package main

data class Server(
    val url: String,
    val description: String? = null,
    val variables: Map<String, String>? = mapOf()
)

class ServerBuilder{
    private var url: String = "/"
    private var description: String? = null
//    private var variables: Map<String, String>

    fun url(block: () -> String) { url = block() }
    fun description(block: () -> String) { description = block() }
//    fun variables(block: () -> String) { description = block() }

    fun build() = Server(url, description)
}

//fun server(block: ServerBuilder.() -> Unit): Server {
//    return ServerBuilder().apply(block).build()
//}