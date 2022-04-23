package com.dreamstore.common

class Price(price: Int) {
    var price: Int

    init {
        if(price < 0) throw IllegalArgumentException("가격은 0이상어야 합니다")
        this.price = price
    }
}