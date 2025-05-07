package com.target.forecast.model

import com.taget.forecast.core.model.Product
import org.springframework.data.mongodb.repository.MongoRepository

interface ProductRepository : MongoRepository<Product, String>
