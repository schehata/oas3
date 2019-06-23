package com.schehata.oas3.test

import io.kotlintest.specs.AnnotationSpec

class InfoTest: AnnotationSpec() {
    @Test
    fun `Creating Info should contain all valid data`() {
        val info = validDocument.info
        assert(info.title.isNotBlank())
        assert(info.description.isNullOrBlank())
        assert(info.termsOfService == null)
        assert(info.contact!!.name!!.isNotBlank())
        assert(info.contact!!.email!!.isNotBlank())
        assert(info.license!!.name.isNotBlank())
        assert(info.license!!.url == null)
        assert(!info.version.isNullOrBlank())
    }
}
