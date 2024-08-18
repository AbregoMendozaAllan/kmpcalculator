package com.eonarma.kmpcalculator

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform