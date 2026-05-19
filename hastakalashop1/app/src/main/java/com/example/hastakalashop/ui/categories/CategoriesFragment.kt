package com.example.hastakalashop.ui.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hastakalashop.databinding.FragmentCategoriesBinding

class CategoriesFragment : Fragment() {

    private var _binding: FragmentCategoriesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCategoriesBinding.inflate(inflater, container, false)
        
        setupCategories()
        
        return binding.root
    }

    private fun setupCategories() {
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
        
        binding.rvCategories.adapter = CategoryAdapter(categories)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
