package com.example.core.data.mapper

import com.example.core.data.network.Content
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mapstruct.factory.Mappers

class ContentMapperTest {
    
    @Test
    fun convertToDbContent() {
        val converter = Mappers.getMapper(ContentMapper::class.java)

        //Network Object
        val networkObject = Content(
            backdropPath = "/dKxkwAJfGuznW8Hu0mhaDJtna0n.jpg",
            firstAirDate = "2012-10-10",
            genreIds = listOf(3, 4, 76),
            id = 435,
            name = "Arrow",
            originCountry = listOf("X", "Y", "Z"),
            originalLanguage = "ENG",
            originalName = "English",
            overview = "Long overview...",
            popularity = 12.00,
            posterPath = "/fwehfog430t03ug34gg43g3.jpg",
            voteAverage = 5.00,
            voteCount = 23
        )

        val dataBaseContent = converter.convertToDbContent(networkObject)

        assertEquals(dataBaseContent.backdropPath, "/dKxkwAJfGuznW8Hu0mhaDJtna0n.jpg")
        assertEquals(dataBaseContent.id, 435)
        assertEquals(dataBaseContent.genreIds.size, 3)
        assertEquals(dataBaseContent.genreIds, listOf(3, 4, 76))
        assertEquals(dataBaseContent.originCountry[0], listOf("X", "Y", "Z")[0])
    }

}
