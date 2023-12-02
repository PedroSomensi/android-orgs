package com.somensi.orgs.ui.activity

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.somensi.orgs.R
import com.somensi.orgs.dao.ProductDao
import com.somensi.orgs.databinding.ActivityProductsListBinding
import com.somensi.orgs.recycler.adapter.ProductListAdapter

class ProductListActivity: AppCompatActivity(R.layout.activity_products_list) {
    private val productsDao = ProductDao()
    private val adapter = ProductListAdapter(context = this, products = productsDao.all())

    private val binding by lazy {
        ActivityProductsListBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupRecyclerView()
        setupFloatingButton()

        AlertDialog.Builder(this)
            .setMessage("mensagem de teste")
            .setTitle("Titule de teste")
            .setView(R.layout.form_image)
            .setPositiveButton("Confirmar") { _, _ ->

            }
            .setNegativeButton("Cancelar") { _, _ ->

            }
            .show()

    }

    override fun onResume() {
        super.onResume()
        adapter.update(productsDao.all())
    }

    private fun setupRecyclerView() {
        val recyclerView = binding.productsListRecyclerView
        recyclerView.adapter = adapter
    }

    private fun goToFormProduct() {
        val intent = Intent(this, FormProductActivity::class.java)
        startActivity(intent)
    }

    private fun setupFloatingButton() {
        val floatingButton = binding.productsListFloatingActionButton
        floatingButton.setOnClickListener {
            goToFormProduct()
        }
    }

}