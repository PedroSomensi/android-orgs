package com.somensi.orgs.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.somensi.orgs.R
import com.somensi.orgs.databinding.ActivityProductDetailsBinding
import com.somensi.orgs.model.Product
import com.somensi.orgs.utils.downloadImage
import com.somensi.orgs.utils.formatToString

class ProductDetailActivity : AppCompatActivity(R.layout.activity_product_details) {

    private val binding by lazy {
        ActivityProductDetailsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        loadInformations()
    }

    private fun loadInformations() {
        intent.getParcelableExtra("product",  Product::class.java).let { product ->
            binding.activityProductDetailsTitle.setText(product?.title)
            binding.activityProductDetailsDescrption.setText(product?.description)
            binding.activityProductDetailsPrice.setText(product?.price?.formatToString())
            binding.activityProductDetailsImageview.downloadImage(product?.image)
        }
    }



}
