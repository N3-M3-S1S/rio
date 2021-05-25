package com.nemesis.rio.data.mplus.seasons.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.nemesis.rio.domain.game.Expansion
import com.nemesis.rio.domain.mplus.seasons.Season

@Dao
abstract class SeasonsDao {

    @Query("SELECT name FROM seasons WHERE expansion = :expansion")
    abstract suspend fun getSeasonsForExpansion(expansion: Expansion): List<Season>

    @Query("SELECT id FROM seasons WHERE api_value = :apiValue")
    abstract suspend fun getSeasonIDForApiValue(apiValue: String): Long?

    @Query("SELECT name FROM seasons WHERE id = (SELECT MAX(id) FROM seasons)")
    abstract suspend fun getLastSeason(): Season

    @Query("SELECT api_value FROM seasons")
    abstract suspend fun getSeasonJsonValues(): List<String>

    @Insert
    internal abstract suspend fun save(seasonEntities: List<SeasonEntity>)
}
