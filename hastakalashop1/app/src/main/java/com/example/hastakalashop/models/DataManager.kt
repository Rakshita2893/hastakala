package com.example.hastakalashop.models

import com.example.hastakalashop.R

object DataManager {
    // Mock Database
    val users = mutableListOf<User>(
        User("1", "Rakshita", "rakshita@hastakala.com", "1234567890", "Bangalore", "customer")
    )
    
    // We'll store the password in the User object for this mock version
    private val userPasswords = mutableMapOf<String, String>(
        "rakshita@hastakala.com" to "123456"
    )

    val wishlist = mutableListOf<Product>()

    fun addUser(user: User, password: String) {
        users.add(user)
        userPasswords[user.email] = password
    }

    fun validateUser(email: String, pass: String): Boolean {
        return userPasswords[email] == pass
    }

    fun toggleWishlist(product: Product) {
        val existing = wishlist.find { it.productId == product.productId }
        if (existing != null) {
            wishlist.remove(existing)
        } else {
            wishlist.add(product)
        }
    }

    fun isWishlisted(productId: String): Boolean {
        return wishlist.any { it.productId == productId }
    }

    fun getProductsByCategory(categoryId: String): List<Product> {
        return when (categoryId) {
            "1" -> listOf( // Pottery
                Product("p1", "Clay Pot", "Hand-painted clay pot", 250.0, "1", "", R.drawable.claypot),
                Product("p2", "Terracotta Vase", "Traditional terracotta vase", 450.0, "1", "", R.drawable.pottery),
                Product("p3", "Ceramic Bowl", "Blue glazed ceramic bowl", 180.0, "1", "", R.drawable.pottery),
                Product("p4", "Earthen Lamp", "Diwali special earthen lamp", 99.0, "1", "", R.drawable.claypot)
            )
            "2" -> listOf( // Jewellery
                Product("j1", "Silver Ring", "Traditional silver ring", 1200.0, "2", "", R.drawable.silverring),
                Product("j2", "Beaded Necklace", "Handmade colorful beads", 550.0, "2", "", R.drawable.jewellery),
                Product("j3", "Gold Plated Bangle", "Temple design bangle", 2200.0, "2", "", R.drawable.jewellery),
                Product("j4", "Earrings", "Jhumka style earrings", 850.0, "2", "", R.drawable.jewellery)
            )
            "3" -> listOf( // Home Decor
                Product("h1", "Handcrafted Vase", "Beautiful ceramic vase", 899.0, "3", "", R.drawable.homedecor),
                Product("h2", "Wall Clock", "Wooden carved wall clock", 1500.0, "3", "", R.drawable.woodenart),
                Product("h3", "Flower Stand", "Metal craft flower stand", 750.0, "3", "", R.drawable.metalcraft),
                Product("h4", "Candle Holder", "Glass and metal holder", 350.0, "3", "", R.drawable.homedecor)
            )
            "4" -> listOf( // Textiles
                Product("t1", "Silk Scarf", "Hand-woven silk scarf", 1200.0, "4", "", R.drawable.textiles),
                Product("t2", "Cotton Saree", "Pure cotton handloom saree", 3500.0, "4", "", R.drawable.textiles),
                Product("t3", "Embroidered Cushion", "Zardosi work cushion", 650.0, "4", "", R.drawable.textiles),
                Product("t4", "Woolen Shawl", "Hand-knitted woolen shawl", 2200.0, "4", "", R.drawable.textiles)
            )
            "5" -> listOf( // Paintings
                Product("pn1", "Madhubani Art", "Traditional folk painting", 1800.0, "5", "", R.drawable.painting),
                Product("pn2", "Oil Landscape", "Scenery on canvas", 2500.0, "5", "", R.drawable.painting),
                Product("pn3", "Warli Art", "Tribal stick figure art", 900.0, "5", "", R.drawable.painting),
                Product("pn4", "Abstract Decor", "Modern abstract painting", 3200.0, "5", "", R.drawable.painting)
            )
            "6" -> listOf( // Wooden Art
                Product("w1", "Wooden Mask", "Tribal wooden mask", 600.0, "6", "", R.drawable.woodenmask),
                Product("w2", "Carved Elephant", "Rosewood elephant statue", 1200.0, "6", "", R.drawable.woodenart),
                Product("w3", "Jewelry Box", "Hand-carved wooden box", 450.0, "6", "", R.drawable.woodenart),
                Product("w4", "Kitchen Ladle", "Neem wood cooking ladle", 150.0, "6", "", R.drawable.woodenart)
            )
            "7" -> listOf( // Metal Craft
                Product("m1", "Metal Vase", "Handcrafted metal vase", 1100.0, "7", "", R.drawable.metalvase),
                Product("m2", "Brass Buddha", "Sitting Buddha statue", 2800.0, "7", "", R.drawable.metalcraft),
                Product("m3", "Iron Lamp", "Hanging iron lantern", 650.0, "7", "", R.drawable.metalcraft),
                Product("m4", "Copper Jug", "Pure copper water jug", 950.0, "7", "", R.drawable.metalcraft)
            )
            "8" -> listOf( // Leather
                Product("l1", "Leather Bag", "Handmade leather bag", 2500.0, "8", "", R.drawable.leather),
                Product("l2", "Leather Wallet", "Slim brown leather wallet", 800.0, "8", "", R.drawable.leather),
                Product("l3", "Leather Belt", "Pure leather formal belt", 600.0, "8", "", R.drawable.leather),
                Product("l4", "Leather Boots", "Hand-stitched leather boots", 4500.0, "8", "", R.drawable.leather)
            )
            "9" -> listOf( // Toys
                Product("ty1", "Wooden Doll", "Channapatna wooden doll", 350.0, "9", "", R.drawable.toys),
                Product("ty2", "Soft Elephant", "Handmade stuffed elephant", 450.0, "9", "", R.drawable.toys),
                Product("ty3", "Spinning Top", "Traditional lacquer top", 150.0, "9", "", R.drawable.toys),
                Product("ty4", "Pull-along Toy", "Wooden dog on wheels", 550.0, "9", "", R.drawable.toys)
            )
            else -> emptyList()
        }
    }
}
