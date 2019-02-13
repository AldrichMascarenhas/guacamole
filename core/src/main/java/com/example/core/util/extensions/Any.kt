package com.example.core.util.extensions


fun Any.tag(): String {
    return this::class.java.simpleName
}