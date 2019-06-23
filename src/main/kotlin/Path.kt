package main

data class Path(
    val ref: String? = null,
    val summary: String? = null,
    val description: String? = null,
    val get: Operation? = null,
    val put: Operation? = null,
    val post: Operation? = null,
    val delete: Operation? = null,
    val options: Operation? = null,
    val head: Operation? = null,
    val patch: Operation? = null,
    val trace: Operation? = null,
    val servers: List<Server>? = null,
    val parameters: Reference? = null
)

class PathBuilder {
    private var ref: String? = null
    private var summary: String? = null
    private var description: String? = null
    private var get: Operation? = null
    private var put: Operation? = null
    private var post: Operation? = null
    private var delete: Operation? = null
    private var options: Operation? = null
    private var head: Operation? = null
    private var patch: Operation? = null
    private var trace: Operation? = null
    private var servers: MutableList<Server>? = null
    private var parameters: Reference? = null

    fun ref(block: () -> String) { ref = block() }
    fun summary(block: () -> String) { summary = block() }
    fun description(block: () -> String) { description = block() }
    fun get(block: OperationBuilder.() -> Unit) { get = OperationBuilder().apply(block).build() }
    fun put(block: OperationBuilder.() -> Unit) { put = OperationBuilder().apply(block).build() }
    fun post(block: OperationBuilder.() -> Unit) { post = OperationBuilder().apply(block).build() }
    fun delete(block: OperationBuilder.() -> Unit) { delete = OperationBuilder().apply(block).build() }
    fun options(block: OperationBuilder.() -> Unit) { options = OperationBuilder().apply(block).build() }
    fun head(block: OperationBuilder.() -> Unit) { head = OperationBuilder().apply(block).build() }
    fun patch(block: OperationBuilder.() -> Unit) { patch = OperationBuilder().apply(block).build() }
    fun trace(block: OperationBuilder.() -> Unit) { trace = OperationBuilder().apply(block).build() }
    fun server(block: ServerBuilder.() -> Unit) {
        if (servers.isNullOrEmpty()) {
            servers = mutableListOf()
        }
        servers!!.add(ServerBuilder().apply(block).build())
    }
    fun parameters(block: () -> Reference) { parameters = block() }

    fun build() = Path(ref, summary, description, get, put, post, delete, options, head, patch, trace, servers,
        parameters)
}
