package com.example.hastakalashop.ui.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hastakalashop.databinding.FragmentProductDetailsBinding

class ProductDetailsFragment : Fragment() {

    private var _binding: FragmentProductDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductDetailsBinding.inflate(inflater, container, false)
        
        setupUI()
        
        return binding.root
    }

    private fun setupUI() {
        binding.ivBack.setOnClickListener {
            androidx.navigation.fragment.NavHostFragment.findNavController(this).popBackStack()
        }

        var isWishlisted = false
        binding.ivWishlist.setOnClickListener {
            isWishlisted = !isWishlisted
            binding.ivWishlist.setImageResource(
                if (isWishlisted) android.R.drawable.btn_star_big_on else android.R.drawable.btn_star_big_off
            )
        }

        var quantity = 1
        binding.ivPlus.setOnClickListener {
            quantity++
            binding.tvQuantity.text = quantity.toString()
        }

        binding.ivMinus.setOnClickListener {
            if (quantity > 1) {
                quantity--
                binding.tvQuantity.text = quantity.toString()
            }
        }

        binding.btnAddToCart.setOnClickListener {
            android.widget.Toast.makeText(context, "Added to Cart!", android.widget.Toast.LENGTH_SHORT).show()
            androidx.navigation.fragment.NavHostFragment.findNavController(this).navigate(com.example.hastakalashop.R.id.navigation_cart)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
