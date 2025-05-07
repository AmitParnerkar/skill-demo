package com.target.forecast

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync

@EnableAsync
@SpringBootApplication
open class IntegrationApplication

fun main(args: Array<String>) {
    runApplication<IntegrationApplication>(*args)
}
