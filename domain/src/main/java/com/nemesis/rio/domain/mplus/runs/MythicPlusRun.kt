package com.nemesis.rio.domain.mplus.runs

import com.nemesis.rio.domain.mplus.Affix
import com.nemesis.rio.domain.mplus.Dungeon
import kotlinx.datetime.Instant
import java.time.Duration

data class MythicPlusRun(
    val dungeon: Dungeon,
    val keystoneLevel: Int,
    val completedAt: Instant,
    val duration: Duration,
    val keystoneUpgrades: Int,
    val score: Float,
    val affixes: Map<Affix.Tier, Affix>,
    val url: String
)
