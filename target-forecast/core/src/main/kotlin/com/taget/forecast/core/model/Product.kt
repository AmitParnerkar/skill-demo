
package com.taget.forecast.core.model

data class Product(
    val id: Long,
    val productName: String,
    val description: String,
    val material: String,
    val dimensions: String,
    val sku: String,
    val price: Double,
    val category: String,
    val productRelationship: String,
    val inventoryQuantity: Int,
    val productImageUrl: String,
    val supplierInformation: String,
    val careInstructions: String
)

    