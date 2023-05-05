package com.hexagonal.product

import com.hexagonal.product.request.RegisterProductRequest
import com.hexagonal.product.response.ProductResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/product")
class ProductController(
    private val productService: ProductService,
) {
    @GetMapping
    fun getProductList(): List<ProductResponse> {
        return productService.getProductList().map { ProductResponse(it) }
    }

    @PostMapping
    fun registerProduct(@RequestBody registerProductRequest: RegisterProductRequest) {
        return productService.registerProduct(registerProductRequest.toDto())
    }
}