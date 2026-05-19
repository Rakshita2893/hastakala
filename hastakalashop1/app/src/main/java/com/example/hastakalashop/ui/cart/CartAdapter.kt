package com.example.hastakalashop.ui.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hastakalashop.databinding.ItemCartBinding
import com.example.hastakalashop.models.Product

class CartAdapter(private val items: MutableList<Product>) :
    RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    class CartViewHolder(val binding: ItemCartBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = ItemCartBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val product = items[position]
        holder.binding.tvProductName.text = product.name
        holder.binding.tvProductPrice.text = "₹${product.price.toInt()}"
        if (product.imageRes != 0) {
            holder.binding.ivProduct.setImageResource(product.imageRes)
        }

        var quantity = 1
        holder.binding.ivPlus.setOnClickListener {
            quantity++
            holder.binding.tvQuantity.text = quantity.toString()
        }

        holder.binding.ivMinus.setOnClickListener {
            if (quantity > 1) {
                quantity--
                holder.binding.tvQuantity.text = quantity.toString()
            }
        }

        holder.binding.ivDelete.setOnClickListener {
            items.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, items.size)
        }
    }

    override fun getItemCount() = items.size
}
