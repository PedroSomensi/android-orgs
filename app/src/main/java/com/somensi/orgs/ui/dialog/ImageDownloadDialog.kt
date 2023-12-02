package com.somensi.orgs.ui.dialog

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import com.somensi.orgs.databinding.FormImageBinding
import com.somensi.orgs.utils.downloadImage
import com.somensi.orgs.utils.getText

class ImageDownloadDialog(private val context: Context) {

    fun show(urlDefault: String? = null,
             whenImageLoaded: (String?) -> Unit
    ) {

        FormImageBinding.inflate(LayoutInflater.from(context)).apply {

            urlDefault?.let {
                formImageImageview.downloadImage(it)
                formImageUrl.setText(it)
            }

            formImageButtonLoad.setOnClickListener {
                val url = formImageUrl.getText
                formImageImageview.downloadImage(url)
            }

            AlertDialog.Builder(context)
                .setView(root)
                .setPositiveButton("Confirmar") { _, _ ->
                    val url = formImageUrl.getText
                    whenImageLoaded(url)
                }
                .setNegativeButton("Cancelar") { _, _ -> }
                .show()

        }

    }

}