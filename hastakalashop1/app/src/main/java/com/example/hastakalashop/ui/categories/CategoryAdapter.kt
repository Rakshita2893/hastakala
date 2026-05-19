package com.example.hastakalashop.ui.categories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hastakalashop.databinding.ItemCategoryBinding
import com.example.hastakalashop.models.Category

class CategoryAdapter(private val categories: List<Category>) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    class CategoryViewHolder(val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = ItemCategoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.binding.tvCategoryName.text = category.name
        if (category.imageRes != 0) {
            holder.binding.ivCategory.setImageResource(category.imageRes)
        } else {
            holder.binding.ivCategory.setImageResource(android.R.drawable.ic_menu_gallery)
        }

        holder.itemView.setOnClickListener {
            val bundle = android.os.Bundle().apply {
                putString("categoryId", category.categoryId)
                putString("categoryName", category.name)
            }
            androidx.navigation.fragment.NavHostFragment.findNavController(holder.itemView.findFragment<androidx.fragment.app.Fragment>())
                .navigate(com.example.hastakalashop.R.id.navigation_product_list, bundle)
        }
    }

    private inline fun <reified T : androidx.fragment.app.Fragment> android.view.View.findFragment(): T {
        return androidx.fragment.app.FragmentManager.findFragment(this)
    }

    override fun getItemCount() = categories.size
}
