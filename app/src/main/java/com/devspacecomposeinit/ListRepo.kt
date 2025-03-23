package com.devspacecomposeinit

class ListRepo {
    private val Picasso = Artist(
        id = 0,
        name = "Picasso",
        description = "Picasso  asoidfjaodaosdjfaoidsjf",
        lastSeenOnline = "1 hour ago",
        img = R.drawable.ic_pablo_picasso,
        art = R.drawable.ic_mona_lisa
    )

    private val Dali =    Artist(
        id = 1,
        name = "Dali Salva",
        description = "Dali fuidshfiudhiuashaiuhf",
        lastSeenOnline = "1 hour ago",
        img = R.drawable.ic_salvador_dali,
        art = R.drawable.ic_beijo
    )
    private val Leao =    Artist(
        id = 2,
        name = "Leao venceu",
        description = "Leonardo vnvxcmvn,xcvnx,cmvn",
        lastSeenOnline = "1 hour ago",
        img = R.drawable.ic_leonardo_da_vinci,
        art = R.drawable.ic_persistence_of_memory
    )
    private val Ze =    Artist(
        id = 3,
        name = "Ze oreia",
        description = "Van hudhasudhuasdhsa",
        lastSeenOnline = "1 hour ago",
        img = R.drawable.ic_vincent_van_gogh,
        art = R.drawable.ic_starry_night
    )

    fun getArtistList(): List<Artist>{
        return listOf(Picasso,Dali,Leao,Ze)
    }


    fun getArtistById(id:Int): Artist{
        return getArtistList().first {it.id == id}
    }
}