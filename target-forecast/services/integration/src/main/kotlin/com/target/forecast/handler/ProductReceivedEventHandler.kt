
package com.target.forecast.handler

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.taget.forecast.core.FileParsedEvent
import com.target.forecast.service.ProductService
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class ProductReceivedEventHandler(val productService: ProductService) {

    private val objectMapper = jacksonObjectMapper()

    @KafkaListener(topics = ["file-parsed-topic"], groupId = "forecast-group")
    fun handle(event: String) {
        println("📥 Received product: $event")
        val parsedEvent = objectMapper.readValue(event, FileParsedEvent::class.java)
        //train model asynchronously
        productService.saveProduct(parsedEvent.product)
    }
}
    