package com.somensi.orgs.utils

import android.widget.EditText
    var EditText.getText : String
        get() = this.text.toString()
        set(value) {
            this.setText(value)
        }

