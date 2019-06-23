package com.schehata.oas3.test

import io.kotlintest.specs.AnnotationSpec
import java.io.File

class DocumentTest: AnnotationSpec() {
    @Test
    fun `Creating a Document should succeed`() {
        val d = validDocument

        assert(d.openapi == "3.0.0")
        assert(d.servers?.count() == 2)
        assert(d.servers?.get(0)?.url ==  "api.schehata.com")
        assert(d.info.version == "1.0.0")
        assert(d.info.contact?.name == "Islam Shehata")
        assert(d.paths.count() == 1)
        assert(d.paths.containsKey("/status"))
    }

    @Test
    fun `Document Tags should contains correct values`() {
        assert(validDocument.tags?.count() == 1)
        val tag = validDocument.tags!!.get(0)!!
        assert(tag.name == "Document Tag")
        assert(tag.description!!.isNotBlank())
        assert(tag.externalDocs!!.url.isNotBlank())
    }

    @Test
    fun `Export document to yaml file should create the file`() {
        val filePath = "/tmp/openapi.yaml"
        validDocument.exportToYamlFile(filePath)

        val file = File(filePath)

        assert(file.exists())
    }

    @Test
    fun `Export document to json file should create the file`() {
        val filePath = "/tmp/openapi.json"
        validDocument.exportToJsonFile(filePath)

        val file = File(filePath)

        assert(file.exists())
    }
}
