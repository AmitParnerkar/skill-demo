
package com.target.forecast.api.com.target.forecast.api.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PredictController {
    @GetMapping("/sales-quantity")
    fun predict(): String = "Predicted sales quantity: 42"
}
    