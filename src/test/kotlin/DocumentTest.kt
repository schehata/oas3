package com.schehata.oas3.test

import io.kotlintest.matchers.maps.shouldContainValue
import io.kotlintest.specs.AnnotationSpec
import main.document

class DocumentTest: AnnotationSpec() {
    @Test
    fun `Creating a Document should succeed`() {
        val d = document {
            openapi { "3" }
            info {
                title { "OpenAPI 3 Spec" }
                version { "1.0.0" }
                contact {
                    name { "Islam Shehata" }
                    email { "schehata@icloud.com" }
                }
                license {
                    name { "GPL 3" }
                }
            }
            server {
                url { "api.schehata.com" }
                description { "server description" }
            }
            server {
                url { "sandbox.schehata.com" }
                description { "Testing Server" }
            }
            path("/status") {
                get {
                    tag { "tag1" }
                    tag { "tag2" }
                    summary { "GET request" }
                    description { "TOO much to write for a desc" }
                    operationId { "getStatus" }
                    deprecated { true }

                }
                post {
                    tag { "tag1" }
                    summary { "GET request" }
                    description { "TOO much to write for a desc" }
                    operationId { "postStatus" }
                }
            }
        }

        assert(d.openapi == "3")
        assert(d.servers?.count() == 2)
        assert(d.servers?.get(0)?.url ==  "api.schehata.com")
        assert(d.info.version == "1.0.0")
        assert(d.info.contact?.name == "Islam Shehata")
        assert(d.paths.count() == 1)
        assert(d.paths.containsKey("/status"))
    }
}