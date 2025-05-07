package com.target.forecast.api.controller

import com.target.forecast.api.model.ProductRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class ProductController(private val productRepository: ProductRepository) {

    @GetMapping("/products")
    fun list(model: Model): String {
        val products = productRepository.findAll()
        model.addAttribute("products", products)
        return "products"
    }
}