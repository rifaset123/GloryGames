package com.rif.glorygames.core.utils

import com.rif.glorygames.core.data.source.local.entity.GameEntity
import com.rif.glorygames.core.data.source.remote.response.GameResponse
import com.rif.glorygames.core.domain.model.Game

object DataMapper {
    fun mapResponsesToEntities(input: List<GameResponse>): List<GameEntity> {
        val gameList = ArrayList<GameEntity>()
        input.map {
            val game =
                GameEntity(
                    gameId = it.id,
                    description = it.description,
                    name = it.name,
                    address = it.address,
                    latitude = it.latitude,
                    longitude = it.longitude,
                    like = it.like,
                    image = it.image,
                    isFavorite = false
                )
            gameList.add(game)
        }
        return gameList
    }

    fun mapEntitiesToDomain(input: List<GameEntity>): List<Game> =
        input.map {
            Game(
                gameId = it.gameId,
                description = it.description,
                name = it.name,
                address = it.address,
                latitude = it.latitude,
                longitude = it.longitude,
                like = it.like,
                image = it.image,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Game) =
        GameEntity(
            gameId = input.gameId,
            description = input.description,
            name = input.name,
            address = input.address,
            latitude = input.latitude,
            longitude = input.longitude,
            like = input.like,
            image = input.image,
            isFavorite = input.isFavorite
        )
}