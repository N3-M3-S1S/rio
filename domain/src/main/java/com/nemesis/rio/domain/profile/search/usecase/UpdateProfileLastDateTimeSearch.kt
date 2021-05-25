package com.nemesis.rio.domain.profile.search.usecase

import com.nemesis.rio.domain.profile.Profile
import com.nemesis.rio.domain.profile.search.ProfileSearchHistorySource

class UpdateProfileLastDateTimeSearch<P : Profile>
    (private val profileSearchHistorySource: ProfileSearchHistorySource<P>) {

    suspend operator fun invoke(profile: P) {
        profileSearchHistorySource.addOrUpdate(profile)
    }
}
