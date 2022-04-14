package com.dreamStore.product

import com.dreamStore.domain.product.ProductService
import com.dreamStore.product.requstDTO.RegisterProductRequest
import com.dreamStore.product.responseDTO.ProductResponse
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
    fun registerProduct(@RequestBody registerProductRequest: RegisterProductRequest){
        return productService.registerProduct(registerProductRequest.toDto())
    }
}