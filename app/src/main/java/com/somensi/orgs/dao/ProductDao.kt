package com.somensi.orgs.dao

import com.somensi.orgs.model.Product
import java.math.BigDecimal

class ProductDao {

    fun add(product: Product) {
        products.add(product)
    }

    fun all() : List<Product> {
        return products.toList()
    }

    companion object {
        private val products = mutableListOf<Product>(
            Product(
                title = "Salada de frutas",
                description = "Laranja, maçãs e uva",
                price = BigDecimal("12.83")
            )
        )
    }

}