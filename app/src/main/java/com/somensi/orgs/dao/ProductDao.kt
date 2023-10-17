package com.somensi.orgs.dao

import com.somensi.orgs.model.Product

class ProductDao {

    fun add(product: Product) {
        products.add(product)
    }

    fun all() : List<Product> {
        return products.toList()
    }

    companion object {
        private val products = mutableListOf<Product>()
    }

}