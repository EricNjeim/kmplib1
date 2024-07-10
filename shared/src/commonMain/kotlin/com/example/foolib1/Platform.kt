package com.example.foolib1

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform