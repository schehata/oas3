package com.schehata.oas3.test

import main.document

val validDocument = document {
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
    tag {
        name { "Document Tag"}
        description { "Description of the document tag" }
        doc {
            url { "http://spec.openapis.org/oas/v3.0.2#tagObject" }
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
