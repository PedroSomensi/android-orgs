package com.somensi.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.somensi.orgs.R
import com.somensi.orgs.dao.ProductDao
import com.somensi.orgs.recycler.adapter.ProductListAdapter

class ProductListActivity: AppCompatActivity() {
    private val productsDao = ProductDao()
    private val adapter = ProductListAdapter(context = this, products = productsDao.all())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products_list)

        setupRecyclerView()
        setupFloatingButton()
    }

    override fun onResume() {
        super.onResume()
        adapter.update(productsDao.all())
    }

    private fun setupRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = adapter
    }

    private fun goToFormProduct() {
        val intent = Intent(this, FormProductActivity::class.java)
        startActivity(intent)
    }

    private fun setupFloatingButton() {
        val floatingButton = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        floatingButton.setOnClickListener {
            goToFormProduct()
        }
    }

}