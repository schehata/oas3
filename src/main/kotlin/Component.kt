package main

data class Component(
    val schema: Map<String, Reference>? = null,
    val responses: Map<String, Reference>? = null,
    val parameters: Map<String, Reference>? = null,
    val examples: Map<String, Reference>? = null,
    val requestBodies: Map<String, Reference>? = null,
    val headers: Map<String, Reference>? = null,
    val securitySchemes: Map<String, Reference>? = null,
    val links: Map<String, Reference>? = null,
    val callbacks: Map<String, Reference>? = null
)
