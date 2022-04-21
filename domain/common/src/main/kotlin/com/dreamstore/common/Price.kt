package com.dreamstore.common

class Price(price: Int) {
    val price:BigDecimal
    init {
        if(price < 0) throw IllegalArgumentException("가격은 0이상어야 합니다")
        this.price = BigDecimal(price)
    }
}