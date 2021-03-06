package com.nemesis.rio.domain.profile.search.usecase

import com.nemesis.rio.domain.profile.Profile
import com.nemesis.rio.domain.profile.search.ProfileSearchHistoryRepository

class RemoveProfileFromSearchHistory<P : Profile>
    (private val profileSearchHistoryRepository: ProfileSearchHistoryRepository<P>) {

    suspend operator fun invoke(profile: P) {
        profileSearchHistoryRepository.remove(profile)
    }
}
