package com.schehata.oas3.test

import io.kotlintest.specs.AnnotationSpec
import main.document

class SecurityRequirementsTest: AnnotationSpec() {
    @Test
    fun `Security object should have items in the array if its oauth2`() {
        val security = validDocument.security
        assert(!security.isNullOrEmpty()) {
            "security object shouldn't null"
        }
        assert(!security!!["oauth2"]!!.isEmpty()) {
            "security scopes list shouldn't be empty when the scheme is oauth2"
        }
    }

    @Test
    fun `Security object scopes could be empty`() {
        val d = document {
            security("basic") {
            }
        }
        assert(d.security!!["basic"]!!.isEmpty()) {
            "security object scopes should be empty when not provided"
        }
    }
}
