package com.somensi.orgs.recycler.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.somensi.orgs.databinding.ProductItemBinding
import com.somensi.orgs.model.Product
import com.somensi.orgs.utils.downloadImage
import java.math.BigDecimal
import java.text.NumberFormat
import java.util.Locale

class ProductListAdapter(
    products: List<Product>,
    private val context: Context,
    var clickOnItem: ClickOnItemListener = object : ClickOnItemListener {
        override fun clicked(product: Product) { }
    }
) : RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {

    private val products = products.toMutableList()

    interface ClickOnItemListener {
        fun clicked(product: Product)
    }

    inner class ViewHolder(private val binding: ProductItemBinding) : RecyclerView.ViewHolder(binding.root) {

        private val title = binding.productItemTitle
        private val description = binding.productItemDescription
        private val price = binding.productItemPrice

        private lateinit var product: Product

        init {
            itemView.setOnClickListener {
                if(::product.isInitialized) {
                    clickOnItem.clicked(product)
                }
            }
        }

        fun build(product: Product) {
            this.product = product
            title.text = product.title
            description.text = product.description
            price.text = formatPrice(product.price)
            downloadImage(product.image)
        }

        private fun downloadImage(url: String?) {
            binding.imageView.downloadImage(url)
        }

        private fun formatPrice(value: BigDecimal): String {
            val formatter: NumberFormat = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
            return formatter.format(value)
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

    @SuppressLint("NotifyDataSetChanged")
    fun update(products: List<Product>) {
        this.products.clear()
        this.products.addAll(products)
        notifyDataSetChanged()
    }

}
