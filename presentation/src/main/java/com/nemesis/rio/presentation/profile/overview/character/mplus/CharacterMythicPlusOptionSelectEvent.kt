package com.nemesis.rio.presentation.profile.overview.character.mplus

import com.nemesis.rio.domain.game.Expansion
import com.nemesis.rio.domain.mplus.ranks.MythicPlusRanksScope
import com.nemesis.rio.domain.mplus.runs.sorting.MythicPlusRunsSortingOption
import com.nemesis.rio.domain.mplus.seasons.Season
import com.nemesis.rio.domain.profile.Faction
import com.nemesis.rio.domain.sorting.SortingOrder
import com.nemesis.rio.presentation.mplus.ranks.MythicPlusRanksType
import com.nemesis.rio.presentation.mplus.scores.MythicPlusScoresType

sealed class CharacterMythicPlusOptionSelectEvent

data class SelectScoresType(val selectedScoresType: MythicPlusScoresType) :
    CharacterMythicPlusOptionSelectEvent()

data class SelectScoresSeason(
    val expansionsWithSeasons: Map<Expansion, List<Season>>,
    val selectedSeason: Season
) :
    CharacterMythicPlusOptionSelectEvent()

data class SelectRanksType(val selectedRanksType: MythicPlusRanksType) :
    CharacterMythicPlusOptionSelectEvent()

data class SelectRanksScope(
    val selectedRanksScope: MythicPlusRanksScope?,
    val faction: Faction
) : CharacterMythicPlusOptionSelectEvent()

data class SelectRunsSoringOption(val selectedSortingOption: MythicPlusRunsSortingOption) :
    CharacterMythicPlusOptionSelectEvent()

data class SelectRunsSortingOrder(val selectedSortingOrder: SortingOrder) :
    CharacterMythicPlusOptionSelectEvent()
