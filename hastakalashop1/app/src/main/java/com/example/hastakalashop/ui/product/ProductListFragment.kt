package com.example.hastakalashop.ui.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hastakalashop.databinding.FragmentProductListBinding
import com.example.hastakalashop.ui.home.HomeFragment

class ProductListFragment : Fragment() {

    private var _binding: FragmentProductListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductListBinding.inflate(inflater, container, false)
        
        val categoryName = arguments?.getString("categoryName") ?: "Products"
        binding.tvCategoryTitle.text = categoryName

        binding.ivBack.setOnClickListener {
            androidx.navigation.fragment.NavHostFragment.findNavController(this).popBackStack()
        }

        binding.ivFilter.setOnClickListener {
            android.widget.Toast.makeText(context, "Filter clicked", android.widget.Toast.LENGTH_SHORT).show()
        }

        binding.ivHome.setOnClickListener {
            androidx.navigation.fragment.NavHostFragment.findNavController(this).navigate(com.example.hastakalashop.R.id.navigation_home)
        }

        setupProductList()
        
        return binding.root
    }

    private fun setupProductList() {
        val categoryId = arguments?.getString("categoryId") ?: ""
        val products = com.example.hastakalashop.models.DataManager.getProductsByCategory(categoryId)
        binding.rvProducts.adapter = HomeFragment.ProductAdapter(products)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
