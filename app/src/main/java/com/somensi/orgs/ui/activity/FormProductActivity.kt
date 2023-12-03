package com.somensi.orgs.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.somensi.orgs.R
import com.somensi.orgs.dao.ProductDao
import com.somensi.orgs.databinding.ActivityFormProductBinding
import com.somensi.orgs.model.Product
import com.somensi.orgs.ui.dialog.ImageDownloadDialog
import com.somensi.orgs.utils.downloadImage
import com.somensi.orgs.utils.getText
import java.math.BigDecimal

class FormProductActivity : AppCompatActivity(R.layout.activity_form_product) {

    private val productDAO = ProductDao()

    private var urlImage: String? = null

    private val binding by lazy {
        ActivityFormProductBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Cadastrar produto"
        setupButton()

        setContentView(binding.root)

        binding.activityFormProductImageview.setOnClickListener {
            ImageDownloadDialog(this).show(urlImage) { url ->
                urlImage = url
                binding.activityFormProductImageview.downloadImage(urlImage)
            }
        }

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
            price = price,
            image = urlImage
        )

    }

}

