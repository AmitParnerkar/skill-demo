package com.target.demo.event

data class FileReceivedEvent(
    val fileName: String,
    val s3BucketURL: String
)