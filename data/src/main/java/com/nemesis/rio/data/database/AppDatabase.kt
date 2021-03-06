package com.nemesis.rio.data.database

import android.content.Context
import androidx.room.*
import com.nemesis.rio.data.database.migrations.Migration_1_2
import com.nemesis.rio.data.game.database.ExpansionConverters
import com.nemesis.rio.data.mplus.ranks.database.MythicPlusRanksDao
import com.nemesis.rio.data.mplus.ranks.database.MythicPlusRanksEntity
import com.nemesis.rio.data.mplus.ranks.database.MythicPlusRoleRanksEntity
import com.nemesis.rio.data.mplus.ranks.database.MythicPlusSpecRanksEntity
import com.nemesis.rio.data.mplus.runs.database.MythicPlusRunAffixesEntity
import com.nemesis.rio.data.mplus.runs.database.MythicPlusRunEntity
import com.nemesis.rio.data.mplus.runs.database.MythicPlusRunsDao
import com.nemesis.rio.data.mplus.scores.colors.database.MythicPlusScoreColorDao
import com.nemesis.rio.data.mplus.scores.colors.database.MythicPlusScoreColorEntity
import com.nemesis.rio.data.mplus.scores.database.MythicPlusOverallScoreEntity
import com.nemesis.rio.data.mplus.scores.database.MythicPlusRoleScoreEntity
import com.nemesis.rio.data.mplus.scores.database.MythicPlusScoresDao
import com.nemesis.rio.data.mplus.scores.database.MythicPlusSpecScoreEntity
import com.nemesis.rio.data.mplus.seasons.database.SeasonEntity
import com.nemesis.rio.data.mplus.seasons.database.SeasonsDao
import com.nemesis.rio.data.profile.character.database.CharacterDao
import com.nemesis.rio.data.profile.character.database.CharacterEntity
import com.nemesis.rio.data.profile.character.database.attributes.CharacterAttributesEntity
import com.nemesis.rio.data.profile.character.database.gear.GearEntity
import com.nemesis.rio.data.profile.guild.database.GuildDao
import com.nemesis.rio.data.profile.guild.database.GuildEntity
import com.nemesis.rio.data.raiding.achievements.database.RaidAchievementsDao
import com.nemesis.rio.data.raiding.achievements.database.RaidAchievementsEntity
import com.nemesis.rio.data.raiding.progress.database.RaidProgressDao
import com.nemesis.rio.data.raiding.progress.database.RaidProgressEntity
import com.nemesis.rio.data.raiding.ranks.database.RaidRanksDao
import com.nemesis.rio.data.raiding.ranks.database.RaidRanksEntity

@Database(
    entities = [
        CharacterEntity::class,
        CharacterAttributesEntity::class,
        GearEntity::class,

        GuildEntity::class,

        MythicPlusRanksEntity::class,
        MythicPlusSpecRanksEntity::class,
        MythicPlusRoleRanksEntity::class,

        MythicPlusOverallScoreEntity::class,
        MythicPlusRoleScoreEntity::class,
        MythicPlusSpecScoreEntity::class,
        MythicPlusScoreColorEntity::class,

        MythicPlusRunEntity::class,
        MythicPlusRunAffixesEntity::class,

        RaidRanksEntity::class,
        RaidProgressEntity::class,
        RaidAchievementsEntity::class,

        SeasonEntity::class],
    version = 5,
    autoMigrations = [AutoMigration(from = 2, to = 3), AutoMigration(from = 3, to = 4)]
)

@TypeConverters(value = [DateTimeConverters::class, ExpansionConverters::class])
abstract class AppDatabase : RoomDatabase() {
    protected abstract val _characterDao: CharacterDao
    protected abstract val _guildDao: GuildDao

    val characterDao
        get() = _characterDao.apply { setRoomDatabase(this@AppDatabase) }

    val guildDao
        get() = _guildDao.apply { setRoomDatabase(this@AppDatabase) }

    abstract val raidAchievementsDao: RaidAchievementsDao
    abstract val raidProgressDao: RaidProgressDao
    abstract val raidRanksDao: RaidRanksDao

    abstract val mythicPlusScoresDao: MythicPlusScoresDao
    abstract val mythicPlusScoreColorDao: MythicPlusScoreColorDao
    abstract val mythicPlusRunsDao: MythicPlusRunsDao
    abstract val mythicPlusRanksDao: MythicPlusRanksDao

    abstract val seasonsDao: SeasonsDao

    companion object {
        private const val DATABASE_NAME = "db"

        fun build(context: Context) =
            Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .addMigrations(Migration_1_2)
                .fallbackToDestructiveMigrationFrom(4)
                .build()
    }
}
