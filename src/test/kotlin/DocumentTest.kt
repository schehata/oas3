package com.schehata.oas3.test

import io.kotlintest.specs.AnnotationSpec

class DocumentTest: AnnotationSpec() {
    @Test
    fun `Creating a Document should succeed`() {
        val d = validDocument

        assert(d.openapi == "3")
        assert(d.servers?.count() == 2)
        assert(d.servers?.get(0)?.url ==  "api.schehata.com")
        assert(d.info.version == "1.0.0")
        assert(d.info.contact?.name == "Islam Shehata")
        assert(d.paths.count() == 1)
        assert(d.paths.containsKey("/status"))
    }

    fun `Document Tags should contains correct values`() {
        assert(validDocument.tags?.count() == 1)
        val tag = validDocument.tags!!.get(0)!!
        assert(tag.name == "Document Tag")
        assert(tag.description!!.isNotBlank())
        assert(tag.externalDocs!!.url.isNotBlank())
    }
}
