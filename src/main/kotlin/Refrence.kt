package main

data class Reference(override var `$ref`: String?) : Referable()

class ReferenceBuilder {
    var ref: String = ""

    fun build() = Reference(ref)
}
