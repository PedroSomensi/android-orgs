package com.somensi.orgs.ui.dialog

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import com.somensi.orgs.databinding.FormImageBinding
import com.somensi.orgs.utils.downloadImage
import com.somensi.orgs.utils.getText

class ImageDownloadDialog(private val context: Context) {

    fun show(urlDefault: String? = null, whenImageLoaded: (String?) -> Unit) {
        val binding = FormImageBinding.inflate(LayoutInflater.from(context))

        urlDefault?.let {
            binding.formImageImageview.downloadImage(it)
            binding.formImageUrl.setText(it)
        }

        binding.formImageButtonLoad.setOnClickListener {
            val url = binding.formImageUrl.getText
            binding.formImageImageview.downloadImage(url)
        }

        AlertDialog.Builder(context)
            .setView(binding.root)
            .setPositiveButton("Confirmar") { _, _ ->
                val url = binding.formImageUrl.getText
                whenImageLoaded(url)
            }
            .setNegativeButton("Cancelar") { _, _ -> }
            .show()

    }

}