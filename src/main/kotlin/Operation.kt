package main

data class Operation(
    val tags: List<String>? = null,
    val summary: String? = null,
    val description: String? = null,
    val externalDocs: List<ExternalDocumentation>? = null,
    val operationId: String? = null,
    val parameters: Reference?,
    val requestBody: Reference?,
    val responses: List<Response>,
    val callbacks: Map<String, Reference>?,
    val deprecated: Boolean = false,
    val security: SecurityRequirement? = null,
    val servers: List<Server>
)

class OperationBuilder {
    private var tags: ArrayList<String> = arrayListOf()
    private var summary: String? = null
    private var description: String? = null
    private var externalDocs: ArrayList<ExternalDocumentation> = arrayListOf()
    private var operationId: String? = null
    private var parameters: Reference? = null
    private var requestBody: Reference? = null
    private var responses: ArrayList<Response> = arrayListOf()
    private var callbacks: Map<String, Reference>? = mapOf()
    private var deprecated: Boolean = false
    private var security: SecurityRequirement? = null
    private var servers: ArrayList<Server> = arrayListOf()

    fun tag(block: () -> String) { tags.add(block()) }
    fun summary(block: () -> String) { summary = block() }
    fun description(block: () -> String) { description = block() }
    fun doc(block: ExternalDocumentationBuilder.() -> Unit) {
        externalDocs.add(ExternalDocumentationBuilder().apply(block).build())
    }
    fun operationId(block: () -> String) { operationId = block() }
    fun parameters(block: () -> Reference) { parameters = block() }
    fun requestBody(block: () -> Reference) { requestBody = block() }
    fun response(block: ResponseBuilder.() -> Unit) {
        responses.add(ResponseBuilder().apply(block).build())
    }
    fun deprecated(block: () -> Boolean) { deprecated = block() }
    fun security(block: SecurityRequirementBuilder.() -> Unit) {
        security = SecurityRequirementBuilder().apply(block).build()
    }
    fun server(block: ServerBuilder.() -> Unit) {
        servers.add(ServerBuilder().apply(block).build())
    }

    fun build() = Operation(tags, summary, description, externalDocs, operationId, parameters, requestBody, responses,
        callbacks, deprecated, security, servers)

}
