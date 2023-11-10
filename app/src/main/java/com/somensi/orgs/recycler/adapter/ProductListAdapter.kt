package com.somensi.orgs.recycler.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.somensi.orgs.R
import com.somensi.orgs.databinding.ProductItemBinding
import com.somensi.orgs.model.Product

class ProductListAdapter(
    products: List<Product>,
    private val context: Context
) : RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {

    private val products = products.toMutableList()

    class ViewHolder(binding: ProductItemBinding) : RecyclerView.ViewHolder(binding.root) {

        private val title = binding.productItemTitle
        private val description = binding.productItemDescription
        private val price = binding.productItemPrice

        fun build(product: Product) {
            title.text = product.title
            description.text = product.description
            price.text = product.price.toEngineeringString()
        }

    }

    override fun getItemCount(): Int = products.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = ProductItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        holder.build(product)
    }

    fun update(products: List<Product>) {
        this.products.clear()
        this.products.addAll(products)
        notifyDataSetChanged()
    }

}
