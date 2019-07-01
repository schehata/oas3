package com.schehata.oas3.test

import io.kotlintest.specs.AnnotationSpec

class ParameterTest : AnnotationSpec() {
    @Test
    fun `Parameters could be a parameter object or reference`() {
        val d = validDocument
        assert(d.paths["/status"]?.parameters!!.count() == 2)
//        assert(d.paths["/status"]?.parameters!![1])
    }
}