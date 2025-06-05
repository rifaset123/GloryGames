package com.rif.glorygames.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.rif.glorygames.core.domain.model.Game
import com.rif.glorygames.R
import com.rif.glorygames.databinding.ActivityDetailGameBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailGameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailGameBinding

    private val detailGameViewModel: DetailGameViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        val detailGame = intent.getParcelableExtra<Game>(EXTRA_DATA)
        showDetailTourism(detailGame)
    }

    private fun showDetailTourism(detailGame: Game?) {
        detailGame?.let {
            supportActionBar?.title = detailGame.name
            binding.contentDetailTourism.tvDetailReleaseDate.text = detailGame.releaseDate
            binding.contentDetailTourism.tvDetailRatingPlace.text = detailGame.rating.toString() + "/5"
            binding.contentDetailTourism.tvDetailPlaytimePlace.text = detailGame.playtime.toString() + " Hour(s)"
            binding.contentDetailTourism.tvDetailTotalRatingPlace.text = detailGame.ratingCount.toString() + " User(s)"
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
