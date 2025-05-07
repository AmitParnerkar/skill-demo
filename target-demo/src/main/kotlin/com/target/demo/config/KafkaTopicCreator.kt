package com.target.demo.config

import org.apache.kafka.clients.admin.AdminClient
import org.apache.kafka.clients.admin.NewTopic
import org.slf4j.LoggerFactory
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.kafka.core.KafkaAdmin
import org.springframework.stereotype.Component

@Component
class KafkaTopicCreator(
    private val kafkaAdmin: KafkaAdmin
) {

    private val log = LoggerFactory.getLogger(KafkaTopicCreator::class.java)

    @EventListener(ApplicationReadyEvent::class)
    fun onApplicationReady() {
        val topicsToCreate = listOf("file-received-topic", "file-parsed-topic")
        AdminClient.create(kafkaAdmin.configurationProperties).use { adminClient ->
            val existingTopics = adminClient.listTopics().names().get()

            topicsToCreate.filterNot { it in existingTopics }.forEach { topic ->
                adminClient.createTopics(listOf(
                    NewTopic(topic, 3, 1.toShort())
                ))
                log.info("✅ Created missing Kafka topic: $topic")
            }

            val finalTopics = adminClient.listTopics().names().get()
            log.info("✅ Available Kafka topics after creation: $finalTopics")
        }

    }
}
