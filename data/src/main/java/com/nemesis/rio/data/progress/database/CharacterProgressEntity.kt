package com.nemesis.rio.data.progress.database

import androidx.room.ColumnInfo
import com.nemesis.rio.data.profile.database.ProfileEntity

abstract class CharacterProgressEntity(
    @ColumnInfo(
        name = ProfileEntity.ID_COLUMN_NAME,
        index = true
    ) val characterID: Long
)
