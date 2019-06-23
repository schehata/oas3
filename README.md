# OAS3 (OpenAPI3)

OAS3 is a Kotlin package to build OpenAPI 3 spec files in DSL.


### Example

```kotlin
document {
    openapi = "3.0.0"
    info {
        title = "OpenAPI 3 Spec"
        version = "1.0.0"
        contact {
            name = "Islam Shehata"
            email = "schehata@icloud.com"
        }
        license {
            name = "GPL 3"
        }
    }
    server {
        url = "api.schehata.com"
        description = "server description"
    }
    server {
        url = "sandbox.schehata.com"
        description = "Testing Server"
    }
    path("/status") {
        get {
            tag { "tag1" }
            tag { "tag2" }
            summary = "GET request"
            description = "TOO much to write for a desc"
            operationId = "getStatus"
            deprecated = true
        }
        post {
            tag { "tag1" }
            summary = "POST request"
            description = "TOO much to write for a desc"
            operationId = "postStatus"
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

Creating info object is straight forward.

- title is required
- version is required

```kotlin
info {
    title = "OpenAPI 3 Spec"
    description = "Descriptive info"
    termsOfService = "Terms Of Service goes here"
    version = "1.0.0"
    contact {
        name ="Islam Shehata"
        email = "schehata@icloud.com"
    }
    license {
        name = "GPL 3"
    }
}
```


### Adding Security Requirements

Security Requirement is a map, it needs a scope and maybe a list of strings.

the `security` dsl object adds a new key/value to the `security` object.

```kotlin
security("oauth2") {
    add("write:pets")
    add("read:pets")
}
security("basic") {}
```



### Adding Paths

To add a path, just use the `path` attribute, you can add as many as needed.

```kotlin
document {
    path("/status") {
        get {
            tag { "tag1" }
            tag { "tag2" }
            summary = "GET request"
            description = "TOO much to write for a desc"
            operationId = "getStatus"
            deprecated = true
    
        }
        post {
            tag { "tag1" }
            summary = "POST request"
            description = "TOO much to write for a desc"
            operationId = "postStatus"
        }
    }
    path("/example") {
       put {
           summary = "PUT Request"
           operationId = "putExample"
       }
       delete {
            summary = "DELETE Request"
           operationId = "deleteExample"
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
        name = "tag name"
        description = "tag description"
        doc {
            url = "required"
            description = "optional"
        }
    }
}
```

 - `name` is **required**

### Exporting document to JSON or YAML

It's very easy to get a string of JSON or YAML
from a document, it uses Jackson to serialize the document.

once you have a document object you can call `json()` or `yaml()` 

```kotlin
val d = document{}
d.json()
d.yaml()
```

It's also possible to save the document to JSON or YAML files. 

```kotlin
val d = document{}
d.exportToJsonFile("file path goes here")
d.exportToYamlFile("file path goes here")
```
