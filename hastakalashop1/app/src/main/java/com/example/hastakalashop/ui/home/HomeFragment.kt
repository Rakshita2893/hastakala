package com.example.hastakalashop.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hastakalashop.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        
        setupHomeContent()
        
        return binding.root
    }

    private fun setupHomeContent() {
        // Setup See All listeners
        binding.tvSeeAllCategories.setOnClickListener {
            androidx.navigation.fragment.NavHostFragment.findNavController(this).navigate(com.example.hastakalashop.R.id.navigation_categories)
        }
        binding.tvSeeAllBestSellers.setOnClickListener {
            // For now, navigating to categories as a placeholder for a full product list
            androidx.navigation.fragment.NavHostFragment.findNavController(this).navigate(com.example.hastakalashop.R.id.navigation_categories)
        }

        // Setup horizontal categories
        val categories = listOf(
            com.example.hastakalashop.models.Category("1", "Pottery", "", com.example.hastakalashop.R.drawable.pottery),
            com.example.hastakalashop.models.Category("2", "Jewellery", "", com.example.hastakalashop.R.drawable.jewellery),
            com.example.hastakalashop.models.Category("3", "Home Decor", "", com.example.hastakalashop.R.drawable.homedecor),
            com.example.hastakalashop.models.Category("4", "Textiles", "", com.example.hastakalashop.R.drawable.textiles),
            com.example.hastakalashop.models.Category("5", "Paintings", "", com.example.hastakalashop.R.drawable.painting),
            com.example.hastakalashop.models.Category("6", "Wooden Art", "", com.example.hastakalashop.R.drawable.woodenart),
            com.example.hastakalashop.models.Category("7", "Metal Craft", "", com.example.hastakalashop.R.drawable.metalcraft),
            com.example.hastakalashop.models.Category("8", "Leather", "", com.example.hastakalashop.R.drawable.leather),
            com.example.hastakalashop.models.Category("9", "Toys", "", com.example.hastakalashop.R.drawable.toys)
        )
        binding.rvCategories.adapter = com.example.hastakalashop.ui.categories.CategoryAdapter(categories)

        // Setup best sellers
        val products = listOf(
            com.example.hastakalashop.models.Product("1", "Clay Pot", "Hand-painted clay pot", 25.0, "1", "", com.example.hastakalashop.R.drawable.claypot),
            com.example.hastakalashop.models.Product("2", "Silver Ring", "Traditional silver ring", 45.0, "2", "", com.example.hastakalashop.R.drawable.silverring),
            com.example.hastakalashop.models.Product("3", "Silk Scarf", "Hand-woven silk scarf", 35.0, "4", "", com.example.hastakalashop.R.drawable.silkscarf),
            com.example.hastakalashop.models.Product("4", "Wooden Mask", "Tribal wooden mask", 60.0, "6", "", com.example.hastakalashop.R.drawable.woodenmask),
            com.example.hastakalashop.models.Product("5", "Metal Vase", "Handcrafted metal vase", 55.0, "7", "", com.example.hastakalashop.R.drawable.metalvase),
            com.example.hastakalashop.models.Product("6", "Leather Bag", "Pure leather handmade bag", 120.0, "8", "", com.example.hastakalashop.R.drawable.leather)
        )
        binding.rvBestSellers.adapter = ProductAdapter(products)
    }

    class ProductAdapter(private val products: List<com.example.hastakalashop.models.Product>) :
        androidx.recyclerview.widget.RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

        class ProductViewHolder(val binding: com.example.hastakalashop.databinding.ItemProductBinding) :
            androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
            val binding = com.example.hastakalashop.databinding.ItemProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return ProductViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
            val product = products[position]
            holder.binding.tvProductName.text = product.name
            holder.binding.tvProductPrice.text = "₹${product.price.toInt()}"
            if (product.imageRes != 0) {
                holder.binding.ivProduct.setImageResource(product.imageRes)
            } else {
                holder.binding.ivProduct.setImageResource(android.R.drawable.ic_menu_gallery)
            }

            // Sync wishlist UI state
            updateWishlistIcon(holder.binding.ivWishlist, product.productId)

            holder.binding.ivWishlist.setOnClickListener {
                com.example.hastakalashop.models.DataManager.toggleWishlist(product)
                updateWishlistIcon(holder.binding.ivWishlist, product.productId)
                
                val message = if (com.example.hastakalashop.models.DataManager.isWishlisted(product.productId)) 
                    "${product.name} added to wishlist" else "${product.name} removed from wishlist"
                android.widget.Toast.makeText(holder.itemView.context, message, android.widget.Toast.LENGTH_SHORT).show()
            }

            holder.itemView.setOnClickListener {
                val bundle = android.os.Bundle().apply {
                    putString("productId", product.productId)
                }
                androidx.navigation.fragment.NavHostFragment.findNavController(holder.itemView.findFragment<androidx.fragment.app.Fragment>())
                    .navigate(com.example.hastakalashop.R.id.navigation_product_details, bundle)
            }
        }

        private fun updateWishlistIcon(imageView: android.widget.ImageView, productId: String) {
            val isWishlisted = com.example.hastakalashop.models.DataManager.isWishlisted(productId)
            imageView.setImageResource(
                if (isWishlisted) android.R.drawable.btn_star_big_on else android.R.drawable.btn_star_big_off
            )
        }

        private inline fun <reified T : androidx.fragment.app.Fragment> android.view.View.findFragment(): T {
            return androidx.fragment.app.FragmentManager.findFragment(this)
        }

        override fun getItemCount() = products.size
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
