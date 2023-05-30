package com.example.laboratorio05.data.model

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.laboratorio05.data.model.MovieModel

data class MovieWithActor (
    @Embedded val movie: MovieModel,
    @Relation(
        parentColumn = "movieId",
        entityColumn = "actorId",
        associateBy = Junction(CastModel::class)
    )
    val actors: List<ActorModel>
        )