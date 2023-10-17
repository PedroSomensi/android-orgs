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
import com.somensi.orgs.dao.ProductDao
import com.somensi.orgs.model.Product
import java.math.BigDecimal
import com.somensi.orgs.recycler.adapter.ProductListAdapter as ProductListAdapter

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        loadProducts()
    }

    private fun loadProducts() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val productsDao = ProductDao()
        recyclerView.adapter = ProductListAdapter(context = this, products = productsDao.all())

        val floatingButton = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        floatingButton.setOnClickListener {
            val intent = Intent(this, FormProductActivity::class.java)
            startActivity(intent)
        }
    }

}