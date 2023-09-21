package com.somensi.orgs

import android.app.Activity
import android.os.Bundle
import android.widget.Toast

class MainActivity: Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(this, "Bem vindo ao Orgs!", Toast.LENGTH_SHORT).show()
    }

}