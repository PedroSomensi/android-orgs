package com.somensi.orgs.ui.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.somensi.orgs.R
import com.somensi.orgs.model.Product
import java.math.BigDecimal
import com.somensi.orgs.recycler.adapter.ProductListAdapter as ProductListAdapter

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = ProductListAdapter(context = this, products = listOf(
            Product(title = "Teste", description = "Teste Description", price = BigDecimal("19.99")),
            Product(title = "Teste1", description = "Teste1 Description", price = BigDecimal("29.99")),
            Product(title = "Teste2", description = "Teste2 Description", price = BigDecimal("39.99")),
        ))

        val floatingButton = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        floatingButton.setOnClickListener {
            val intent = Intent(this, FormProductActivity::class.java)
            startActivity(intent)
        }

    }

}