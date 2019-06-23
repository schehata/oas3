# OAS3 (OpenAPI3)

OAS3 is a Kotlin package to build OpenAPI 3 spec files in DSL.


### Example

```kotlin
document {
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
            summary { "POST request" }
            description { "TOO much to write for a desc" }
            operationId { "postStatus" }
        }
    }
}
```

### Creating Documents

```kotlin
val doc = document {
    // here goes the details of the document
}
```


### Document Info



### Adding Servers



### Adding Paths

To add a path, just use the `path` attribute, you can add as many as needed.

```kotlin
document {
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
            summary { "POST request" }
            description { "TOO much to write for a desc" }
            operationId { "postStatus" }
        }
    }
    path("/example") {
       put {
           summary { "PUT Request" }
           operationId { "putExample" }
       }
       delete {
            summary { "DELETE Request" }
           operationId { "deleteExample" }
       }
    }
}
```


### Adding Tags 

Usually tags is a list of `Tag Object` you can create/append to list of 
tags by using `tag {}`

```kotlin
document {
    tag {
        name { "tag name" }
        description { "tag description" }
        doc {
            url { "" }
            description { "" }
        }
    }
}
```

 - `name` is **required**

### Converting document to JSON

```kotlin
val d = document{}
d.json()
```


### Converting document to YAML

```kotlin
val d = document{}
d.yaml()
```
