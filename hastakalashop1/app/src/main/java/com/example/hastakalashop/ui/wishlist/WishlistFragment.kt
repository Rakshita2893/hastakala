package com.example.hastakalashop.ui.wishlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hastakalashop.databinding.FragmentWishlistBinding

class WishlistFragment : Fragment() {

    private var _binding: FragmentWishlistBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWishlistBinding.inflate(inflater, container, false)
        
        setupWishlist()
        
        return binding.root
    }

    private fun setupWishlist() {
        val wishlistedProducts = com.example.hastakalashop.models.DataManager.wishlist
        
        if (wishlistedProducts.isEmpty()) {
            binding.textWishlist.visibility = View.VISIBLE
            binding.textWishlist.text = "Your Wishlist is empty"
        } else {
            binding.textWishlist.visibility = View.GONE
        }
        
        binding.rvWishlist.adapter = com.example.hastakalashop.ui.home.HomeFragment.ProductAdapter(wishlistedProducts)
    }

    override fun onResume() {
        super.onResume()
        setupWishlist()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
