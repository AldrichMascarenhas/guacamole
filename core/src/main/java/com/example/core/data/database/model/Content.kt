package com.example.core.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.core.util.typeconverter.PrimitiveTypeConverter

@Entity(tableName = "content")
@TypeConverters(PrimitiveTypeConverter::class)
data class Content(
    var backdropPath: String,
    var firstAirDate: String,
    var genreIds: List<Int>,
    @PrimaryKey var id: Int,
    var name: String,
    var originCountry: List<String>,
    var originalLanguage: String,
    var originalName: String,
    var overview: String,
    var popularity: Double,
    var posterPath: String,
    var voteAverage: Double,
    var voteCount: Int
) {
    constructor() : this(
        backdropPath = "",
        firstAirDate = "",
        genreIds = listOf(),
        id = 0,
        name = "",
        originCountry = listOf(),
        originalLanguage = "",
        originalName = "",
        overview = "",
        popularity = 0.0,
        posterPath = "",
        voteAverage = 0.0,
        voteCount = 0
    )
}