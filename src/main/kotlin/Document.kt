package main

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.core.JsonFactory
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import java.io.File

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
    val tags: List<Tag>? = null,
    val externalDocs: ExternalDocumentation? = null
) {

    private fun getYamlMapper(): ObjectMapper {
        val mapper = ObjectMapper(YAMLFactory())
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true)
        return mapper
    }

    private fun getJsonMapper(): ObjectMapper {
        val mapper = ObjectMapper(JsonFactory())
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true)
        return mapper
    }

    fun yaml(): String {
        val mapper = getYamlMapper()
        return mapper.writeValueAsString(this)
    }

    fun json(): String {
        val mapper = getJsonMapper()
        return mapper.writeValueAsString(this)
    }

    fun exportToYamlFile(path: String) {
        val mapper = getYamlMapper()
        return mapper.writeValue(File(path), this)
    }

    fun exportToJsonFile(path: String) {
        val mapper = getJsonMapper()
        return mapper.writeValue(File(path), this)
    }
}

class DocumentBuilder {
    private var openapi: String = ""
    private var info: Info = Info("", null, null, null, null, "")
    private var servers: MutableList<Server>? = null
    private var paths: MutableMap<String, Path> = mutableMapOf()
    private var components: Component? = null
    private var security: SecurityRequirement? = null
    private var tags: ArrayList<Tag>? = null

    fun openapi(block: () -> String) {
        this.openapi = block()
    }

    fun info(block: InfoBuilder.() -> Unit) {
        this.info = InfoBuilder().apply(block).build()
    }

    fun server(block: ServerBuilder.() -> Unit) {
        if (servers.isNullOrEmpty()) {
            servers = mutableListOf()
        }
        servers!!.add(ServerBuilder().apply(block).build())
    }

    fun path(url: String, block: PathBuilder.() -> Unit) {
        paths.put(url, PathBuilder().apply(block).build())
    }

    fun tag(block: TagBuilder.() -> Unit) {
        if(tags.isNullOrEmpty()) {
            tags = arrayListOf()
        }
        tags!!.add(TagBuilder().apply(block).build())
    }

    fun build() = Document(openapi, info, servers, paths, components, security, tags)
}

fun document(block: DocumentBuilder.() -> Unit): Document {
    return DocumentBuilder().apply(block).build()
}
