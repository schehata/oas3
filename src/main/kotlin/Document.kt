package main

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.core.JsonFactory
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature


@DslMarker
internal annotation class DocumentDSL

@DocumentDSL
data class Document (
    val openapi: String,
    val info: Info,
    val servers: List<Server>? = null,
    val paths: Map<String, Path> = mapOf(),
    val components: Component? = null,
    val security: SecurityRequirement? = null,
    val tags: Tag? = null,
    val externalDocs: ExternalDocumentation? = null
) {
    fun toYaml(): String {
        val mapper = ObjectMapper(YAMLFactory())
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsString(this)
    }

    fun json(): String {
        val mapper = ObjectMapper(JsonFactory())
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true)
        return mapper.writeValueAsString(this)
    }
}

class DocumentBuilder {
    private var openapi: String = ""
    private var info: Info = Info("", "", "", Contact(), License(""), "")
    private var servers: ArrayList<Server> = arrayListOf()
    private var paths: MutableMap<String, Path> = mutableMapOf()

    fun openapi(block: () -> String) {
        this.openapi = block()
    }

    fun info(block: InfoBuilder.() -> Unit) {
        this.info = InfoBuilder().apply(block).build()
    }

    fun server(block: ServerBuilder.() -> Unit) {
        servers.add(ServerBuilder().apply(block).build())
    }

    fun path(url: String, block: PathBuilder.() -> Unit) {
        paths.put(url, PathBuilder().apply(block).build())
    }

    fun build() = Document(openapi, info, servers, paths)
}

fun document(block: DocumentBuilder.() -> Unit): Document {
    return DocumentBuilder().apply(block).build()
}
