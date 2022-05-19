package com.dreamstore.common

class Price(price: Int) {
    var value: Int
        private set

    init {
        if(price < 0) throw IllegalArgumentException("가격은 0이상어야 합니다")
        this.value = price
    }

    fun plus(price: Price) {
        this.value+=price.value
    }
}