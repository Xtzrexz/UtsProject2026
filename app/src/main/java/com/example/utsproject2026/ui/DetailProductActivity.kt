package com.example.utsproject2026.ui

import android.graphics.Color
import android.os.Bundle
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.example.utsproject2026.R
import com.example.utsproject2026.databinding.ActivityDetailProductBinding
import com.example.utsproject2026.helpers.Config
import com.example.utsproject2026.model.ProductItem
import com.example.utsproject2026.model.Review

class DetailProductActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.title_product_detail)

        // Menangkap data JSON yang dikirimkan via Intent
        val productJson = intent.getStringExtra(Config.EXTRA_PRODUCT)
        val product = Gson().fromJson(productJson, ProductItem::class.java)

        product?.let { item ->
            binding.tvDetailTitle.text = item.title
            binding.tvDetailCategoryStatus.text = "Kategori: ${item.category} | Status: ${item.availabilityStatus}"
            binding.tvDetailPriceRating.text = "Harga: $${item.price} | Rating: ${item.rating} ⭐️"
            binding.tvDetailStock.text = "Stok Tersedia: ${item.stock}"
            binding.tvDetailDescription.text = item.description

            // Menampilkan gambar utama dari kolom images (mengambil gambar indeks pertama jika tersedia)
            val imageUrl = if (item.images.isNotEmpty()) item.images[0] else item.thumbnail
            Glide.with(this)
                .load(imageUrl)
                .placeholder(android.R.drawable.ic_menu_gallery)
                .into(binding.imgProduct)

            // Menampilkan ulasan (review) teratas secara default (Sesuai Poin g)
            if (!item.reviews.isNullOrEmpty()) {
                val topReview = item.reviews[0]
                binding.tvTopReview.text = "Oleh: ${topReview.reviewerName}\nRating: ${topReview.rating}/5\n\"${topReview.comment}\""

                binding.tvSeeAllReviews.setOnClickListener {
                    showAllReviewsDialog(item.reviews)
                }
            } else {
                binding.tvTopReview.text = "Belum ada ulasan untuk produk ini."
                binding.tvSeeAllReviews.visibility = android.view.View.GONE
            }
        }
    }

    private fun showAllReviewsDialog(reviews: List<Review>) {
        if (reviews.isEmpty()) {
            Toast.makeText(this, "Tidak ada ulasan.", Toast.LENGTH_SHORT).show()
            return
        }

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Semua Ulasan (${reviews.size})")

        val reviewsText = reviews.joinToString(separator = "\n\n-------------------------\n\n") { review ->
            "Oleh: ${review.reviewerName} (${review.reviewerEmail})\n" +
            "Rating: ${review.rating}/5 | Tanggal: ${review.date.take(10)}\n" +
            "\"${review.comment}\""
        }

        val scrollView = ScrollView(this).apply {
            setPadding(32, 24, 32, 24)
        }
        val textView = TextView(this).apply {
            text = reviewsText
            textSize = 14f
            setTextColor(Color.BLACK)
        }
        scrollView.addView(textView)

        builder.setView(scrollView)
        builder.setPositiveButton("Tutup") { dialog, _ ->
            dialog.dismiss()
        }
        builder.show()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}