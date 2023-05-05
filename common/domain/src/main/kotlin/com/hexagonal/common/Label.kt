package com.hexagonal.common

class Label(val value: String) {
    init {
        if (value.isEmpty()) throw IllegalArgumentException("라벨 길이는 0이상이어야 합니다")
        if (value.length > 20) throw IllegalArgumentException("라벨 길이는 20이하이어야 합니다")
    }
}