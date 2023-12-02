package com.somensi.orgs.model

import java.math.BigDecimal

data class Product (
    val title: String,
    val description: String,
    val price: BigDecimal,
    val image: String
)
