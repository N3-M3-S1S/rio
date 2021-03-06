package com.nemesis.rio.data.profile.database

import com.nemesis.rio.domain.profile.Profile

class ProfileIDProvider<P : Profile>(
    private val profileDao: ProfileDao<P>,
    private val profileIDCache: ProfileIDCache
) {

    suspend fun getProfileID(profile: P) =
        profileIDCache.get(profile)
            ?: requireNotNull(profileDao.getProfileID(profile)).also {
                profileIDCache.add(
                    profile,
                    it
                )
            }
}

internal suspend inline fun <P : Profile, T> ProfileIDProvider<P>.withProfileID(
    profile: P,
    action: (id: Long) -> T,
) = action(getProfileID(profile))
