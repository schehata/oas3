package main

data class Response(
    val default: String
)

class ResponseBuilder {
    private var default: String = ""

    infix fun default(value: String) { default = value }

    fun build() = Response(default)
}
