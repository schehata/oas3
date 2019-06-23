package main

data class Response(
    val default: String
)

class ResponseBuilder {
    var default: String = ""

    fun build() = Response(default)
}
