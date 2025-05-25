package com.rif.favorite

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rif.favorite.databinding.ActivityFavoriteBinding
import com.rif.glorygames.core.ui.GameAdapter
import com.rif.glorygames.detail.DetailGameActivity
import com.rif.glorygames.core.FavoriteEntryPoint
import dagger.hilt.android.EntryPointAccessors

class FavoriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoriteBinding
    private lateinit var favoriteViewModel: FavoriteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // inject manual hilt because main app doesnt know about favorite module
        val favoriteEntryPoint = EntryPointAccessors.fromApplication(
            applicationContext,
            FavoriteEntryPoint::class.java
        )
        val gameUseCase = favoriteEntryPoint.gameUseCase()

        val factory = FavoriteViewModelFactory(gameUseCase)
        favoriteViewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]


        supportActionBar?.title = "Favorite Game"
        getFavoritedGame()
    }

    private fun getFavoritedGame() {
        val gameAdapter = GameAdapter()
        gameAdapter.onItemClick = { selectedData ->
            val intent = Intent(this, DetailGameActivity::class.java)
            intent.putExtra(DetailGameActivity.EXTRA_DATA, selectedData)
            startActivity(intent)
        }

        favoriteViewModel.favoriteGame.observe(this) { dataGame ->
            gameAdapter.submitList(dataGame)
            binding.viewEmpty.root.visibility =
                if (dataGame.isNotEmpty()) View.GONE else View.VISIBLE
        }

        with(binding.rvTourism) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = gameAdapter
        }
    }
}