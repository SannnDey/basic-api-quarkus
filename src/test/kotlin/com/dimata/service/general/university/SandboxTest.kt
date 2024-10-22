package com.dimata.service.general.university

import io.quarkus.logging.Log
import io.quarkus.test.junit.QuarkusTest
import org.junit.jupiter.api.Test

@QuarkusTest
class SandboxTest {

    @Test
    fun testRun(){
        Log.info(test(
            nim = "2301010057",
            nama = "Surya Jayantara I Putu"
        ))
    }

    fun test(nama : String, nim : String) : String {
        return "Hallo, Nama saya, ${nama}. Nim saya adalah ${nim}"
    }

}