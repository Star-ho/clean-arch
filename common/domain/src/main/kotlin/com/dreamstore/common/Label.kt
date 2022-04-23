package com.dreamstore.common

class Label(val label: String) {
    init {
        if(label.isEmpty())throw IllegalArgumentException("라벨 길이는 0이상이어야 합니다")
        if(label.length>20)throw IllegalArgumentException("라벨 길이는 20이하이어야 합니다")
    }
}