package com.somensi.orgs.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.somensi.orgs.R
import com.somensi.orgs.dao.ProductDao
import com.somensi.orgs.model.Product
import java.math.BigDecimal

class FormProductActivity : AppCompatActivity(R.layout.activity_form_product) {

    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

        val button = findViewById<Button>(R.id.button_save)
        button.setOnClickListener {
            val name = getTextFromEditText(R.id.name)
            val description = getTextFromEditText(R.id.description)

            val value = getTextFromEditText(R.id.value)

            val price = if (value.isBlank()) {
                BigDecimal.ZERO
            } else {
                BigDecimal(value)
            }

            val product = Product(
                title = name,
                description = description,
                price = price
            )

            val productsDao = ProductDao()
            productsDao.add(product)
            finish()
            Log.i("FormProduct", "onCreate: ${productsDao.all()}")
        }

    }

    private fun getTextFromEditText(id: Int) : String {
        val editText = findViewById<EditText>(id)
        val text = editText.text.toString()
        return text
    }


}