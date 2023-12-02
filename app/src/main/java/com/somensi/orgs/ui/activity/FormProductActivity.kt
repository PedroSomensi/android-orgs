package com.somensi.orgs.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.compose.animation.core.withInfiniteAnimationFrameNanos
import com.somensi.orgs.R
import com.somensi.orgs.dao.ProductDao
import com.somensi.orgs.databinding.ActivityFormProductBinding
import com.somensi.orgs.databinding.ActivityProductsListBinding
import com.somensi.orgs.model.Product
import java.math.BigDecimal

import com.somensi.orgs.utils.getText

class FormProductActivity : AppCompatActivity(R.layout.activity_form_product) {

    private val productDAO = ProductDao()

    private val binding by lazy {
        ActivityFormProductBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupButton()

        setContentView(binding.root)
    }

    private fun setupButton() {
        val button = binding.activityFormProductButtonSave
        button.setOnClickListener {
            val product = createProduct()
            productDAO.add(product)
            finish()
        }
    }

    private fun createProduct() : Product {
        val name = binding.activityFormProductName.getText
        val description = binding.productItemDescription.getText
        val value = binding.activityFormProductTextinputlayoutPrice.editText!!.getText

        val price = if (value.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(value)
        }

        return Product(
            title = name,
            description = description,
            price = price
        )

    }

}

