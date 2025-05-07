package com.taget.forecast.core

data class FileReceivedEvent(
    val fileName: String,
    val s3BucketURL: String
)