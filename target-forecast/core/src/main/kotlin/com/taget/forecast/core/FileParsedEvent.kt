package com.taget.forecast.core

import com.taget.forecast.core.model.Product


data class FileParsedEvent(
    val productId: Long,
    val product: Product
)