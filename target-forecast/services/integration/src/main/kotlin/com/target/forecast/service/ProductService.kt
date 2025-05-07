package com.target.forecast.service

import com.taget.forecast.core.model.Product
import com.target.forecast.model.ProductRepository
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service

@Service
open class ProductService(val productRepository: ProductRepository) {

    @Async
    open fun saveProduct(product: Product) {
        productRepository.save(product)
    }
}