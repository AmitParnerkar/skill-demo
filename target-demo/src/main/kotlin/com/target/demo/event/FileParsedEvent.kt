package com.target.demo.event

import com.target.demo.model.Product


data class FileParsedEvent(
    val productId: Long,
    val product: Product
)