package com.somensi.orgs.recycler.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.somensi.orgs.R
import com.somensi.orgs.model.Product

class ProductListAdapter(
    private val products: List<Product>,
    private val context: Context
) : RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun build(product: Product) {
            val title = itemView.findViewById<TextView>(R.id.title)
            title.text = product.title

            val description = itemView.findViewById<TextView>(R.id.description)
            description.text = product.description

            val price = itemView.findViewById<TextView>(R.id.price)
            price.text = product.price.toEngineeringString()
        }

    }

    override fun getItemCount(): Int = products.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.product_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        holder.build(product)
    }

}