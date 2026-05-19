package com.example.hastakalashop.models

data class User(
    val uid: String = "",
    val name: String = "",
    val email: String = "",
    val phone: String = "",
    val address: String = "",
    val role: String = "customer" // "customer" or "admin"
)

data class Product(
    val productId: String = "",
    val name: String = "",
    val description: String = "",
    val price: Double = 0.0,
    val categoryId: String = "",
    val imageUrl: String = "",
    val imageRes: Int = 0,
    val stock: Int = 0,
    val colors: List<String> = emptyList()
)

data class Category(
    val categoryId: String = "",
    val name: String = "",
    val imageUrl: String = "",
    val imageRes: Int = 0
)

data class Order(
    val orderId: String = "",
    val userId: String = "",
    val totalAmount: Double = 0.0,
    val status: String = "Processing", // Processing, Shipped, Delivered, Cancelled
    val createdAt: Long = System.currentTimeMillis()
)

data class OrderItem(
    val itemId: String = "",
    val orderId: String = "",
    val productId: String = "",
    val quantity: Int = 0,
    val price: Double = 0.0
)
