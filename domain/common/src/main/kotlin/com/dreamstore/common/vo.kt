package com.dreamstore.common

import java.math.BigDecimal

class Label(val label: String) {
    init {
        if(label.isNotEmpty())throw IllegalArgumentException("라벨 길이는 0이상이어야 합니다")
        if(label.length<20)throw IllegalArgumentException("라벨 길이는 20이하이어야 합니다")
    }
}

class Price(val price: BigDecimal) {
    init {
        if(price>=BigDecimal.ZERO) throw IllegalArgumentException("가격은 0이상어야 합니다")
    }
}