package com.somensi.orgs.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.somensi.orgs.R
import com.somensi.orgs.dao.ProductDao
import com.somensi.orgs.model.Product
import java.math.BigDecimal

class FormProductActivity : AppCompatActivity(R.layout.activity_form_product) {

    private val productDAO = ProductDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupButton()
    }

    private fun setupButton() {
        val button = findViewById<Button>(R.id.activity_form_product_button_save)
        button.setOnClickListener {
            val product = createProduct()
            productDAO.add(product)
            finish()
        }
    }

    private fun createProduct() : Product {
        val name = getTextFromEditText(R.id.activity_form_product_name)
        val description = getTextFromEditText(R.id.product_item_description)
        val value = getTextFromEditText(R.id.activity_form_product_value)

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

    private fun getTextFromEditText(id: Int) : String {
        val editText = findViewById<EditText>(id)
        val text = editText.text.toString()
        return text
    }

}