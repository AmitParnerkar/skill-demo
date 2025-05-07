
package com.target.forecast.handler

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class FileReceivedEventHandler {

    @KafkaListener(topics = ["file-received-topic"], groupId = "forecast-group")
    fun handle(event: String) {
        println("📥 Received file-received-event: $event")
    }
}
    