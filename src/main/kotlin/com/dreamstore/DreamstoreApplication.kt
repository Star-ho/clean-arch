package com.dreamstore

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DreamstoreApplication

fun main(args: Array<String>) {
    runApplication<DreamstoreApplication>(*args)
}
