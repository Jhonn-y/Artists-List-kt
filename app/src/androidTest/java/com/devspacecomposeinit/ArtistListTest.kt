package com.devspacecomposeinit

import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class ArtistListTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testArtistListTitleDisplayCorrectly() {
        val artistList = emptyList<Artist>()

        composeTestRule.setContent {
            ArtistListContent(
                artistList = artistList,
                onClick = {}
            )
        }

        composeTestRule.onNodeWithText("Title").isDisplayed()

    }

    @Test
    fun testArtistListDisplayCorrectly() {
        val artistList = listOf(
            Artist(
                id = 0,
                name = "teste 1",
                description = "teste 1",
                lastSeenOnline = "0 min",
                img = R.drawable.ic_vincent_van_gogh,
                art = R.drawable.ic_starry_night,
            ),
            Artist(
                id = 0,
                name = "teste 2",
                description = "teste 2",
                lastSeenOnline = "0 min",
                img = R.drawable.ic_vincent_van_gogh,
                art = R.drawable.ic_starry_night,
            ),
            Artist(
                id = 0,
                name = "teste 3",
                description = "teste 3",
                lastSeenOnline = "0 min",
                img = R.drawable.ic_vincent_van_gogh,
                art = R.drawable.ic_starry_night,
            )
        )

        composeTestRule.setContent {
            ArtistListContent(
                artistList = artistList,
                onClick = {}
            )
        }

        artistList.forEach { artist ->
            composeTestRule.onNodeWithText(artist.name).isDisplayed()
            composeTestRule.onNodeWithText(artist.lastSeenOnline).isDisplayed()
        }

    }

    @Test
    fun textArtistListButtonIsTriggeredCorrectly(){
        var artistsClicked:Artist? = null
        val artistList = listOf(
            Artist(
                id = 0,
                name = "teste 1",
                description = "teste 1",
                lastSeenOnline = "0 min",
                img = R.drawable.ic_vincent_van_gogh,
                art = R.drawable.ic_starry_night,
            )
        )

        composeTestRule.setContent {
            ArtistListContent(
                artistList = artistList,
                onClick = {
                    artistsClicked = it
                }
            )
        }

        composeTestRule.onNodeWithText(artistList[0].name).performClick()

        Assert.assertEquals(artistsClicked, artistList[0])
    }

}