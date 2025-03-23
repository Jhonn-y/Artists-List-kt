package com.devspacecomposeinit

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.devspacecomposeinit.ui.theme.ComposeInitTheme

@Composable
fun ArtistListScreen(navController: NavController) {
    val repo = ListRepo()
    val artists = repo.getArtistList()

    ArtistListContent(artists){
        artist -> navController.navigate("artistDetail/${artist.id}")
    }
}


@Composable
fun ArtistListContent(
    artistList: List<Artist>,
    onClick: (Artist) -> Unit
) {

    LazyColumn {
        items(artistList) { artist ->
            ArtistCard(artist = artist, onClick = { onClick.invoke(artist) })
        }
    }
}

@Composable
fun ArtistCard(artist: Artist, onClick: () -> Unit) {
    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.FillWidth,
                painter = painterResource(id = artist.img),
                contentDescription = "Artist Image"
            )
            Spacer(modifier = Modifier.size(16.dp))
            Column {
                Text(
                    text = artist.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = artist.lastSeenOnline,
                    color = Color.Gray
                )
            }
        }
        Card(
            modifier = Modifier.padding(8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop,
                painter = painterResource(artist.art),
                contentDescription = "Artist Art"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeInitTheme {
        val Picasso = Artist(
            id = 0,
            name = "Picasso",
            description = "Picasso  asoidfjaodaosdjfaoidsjf",
            lastSeenOnline = "1 hour ago",
            img = R.drawable.ic_pablo_picasso,
            art = R.drawable.ic_mona_lisa
        )

        val Dali = Artist(
            id = 1,
            name = "Dali Salva",
            description = "Dali fuidshfiudhiuashaiuhf",
            lastSeenOnline = "1 hour ago",
            img = R.drawable.ic_salvador_dali,
            art = R.drawable.ic_beijo
        )
        val Leao = Artist(
            id = 2,
            name = "Leao venceu",
            description = "Leonardo vnvxcmvn,xcvnx,cmvn",
            lastSeenOnline = "1 hour ago",
            img = R.drawable.ic_leonardo_da_vinci,
            art = R.drawable.ic_persistence_of_memory
        )
        val Ze = Artist(
            id = 3,
            name = "Ze oreia",
            description = "Van hudhasudhuasdhsa",
            lastSeenOnline = "1 hour ago",
            img = R.drawable.ic_vincent_van_gogh,
            art = R.drawable.ic_starry_night
        )

        val artists = listOf(Picasso, Dali, Leao, Ze)

        LazyColumn {
            items(artists) { artist ->

                ArtistCard(artist = artist, onClick = {})
            }
        }
    }
}