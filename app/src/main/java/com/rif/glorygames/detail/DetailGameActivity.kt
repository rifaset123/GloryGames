package com.rif.glorygames.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.rif.glorygames.core.domain.model.Game
import com.rif.glorygames.R
import com.rif.glorygames.databinding.ActivityDetailTourismBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailGameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailTourismBinding

    private val detailGameViewModel: DetailGameViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTourismBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        val detailGame = intent.getParcelableExtra<Game>(EXTRA_DATA)
        showDetailTourism(detailGame)
    }

    private fun showDetailTourism(detailGame: Game?) {
        detailGame?.let {
            supportActionBar?.title = detailGame.name
            binding.contentDetailTourism.tvDetailDescription.text = detailGame.releaseDate
            Glide.with(this@DetailGameActivity)
                .load(detailGame.backgroundImage)
                .into(binding.ivDetailImage)

            var statusFavorite = detailGame.isFavorite
            setStatusFavorite(statusFavorite)
            binding.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detailGameViewModel.setFavoriteTourism(detailGame, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_white))
        } else {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_not_favorite_white))
        }
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}
