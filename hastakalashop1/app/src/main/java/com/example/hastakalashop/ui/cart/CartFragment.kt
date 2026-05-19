package com.example.hastakalashop.ui.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hastakalashop.databinding.FragmentCartBinding

class CartFragment : Fragment() {

    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        
        setupCart()
        
        return binding.root
    }

    private fun setupCart() {
        binding.ivBack.setOnClickListener {
            androidx.navigation.fragment.NavHostFragment.findNavController(this).popBackStack()
        }

        val cartItems = mutableListOf(
            com.example.hastakalashop.models.Product("1", "Handcrafted Vase", "", 899.0, "1", "", com.example.hastakalashop.R.drawable.pottery),
            com.example.hastakalashop.models.Product("2", "Macrame Hanging", "", 1099.0, "1", "", com.example.hastakalashop.R.drawable.textiles),
            com.example.hastakalashop.models.Product("3", "Terracotta Lamp", "", 1199.0, "1", "", com.example.hastakalashop.R.drawable.claypot)
        )

        binding.rvCart.adapter = CartAdapter(cartItems)

        binding.btnCheckout.setOnClickListener {
            androidx.navigation.fragment.NavHostFragment.findNavController(this).navigate(com.example.hastakalashop.R.id.navigation_checkout)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
