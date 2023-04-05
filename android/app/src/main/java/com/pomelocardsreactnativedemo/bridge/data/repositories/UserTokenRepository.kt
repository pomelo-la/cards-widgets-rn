package com.pomelocardsreactnativedemo.bridge.data.repositories

import com.pomelo.networking.resource.Resource
import com.pomelo.networking.utils.safeApiCall
import com.pomelocardsreactnativedemo.bridge.data.entities.UserTokenBody
import com.pomelocardsreactnativedemo.bridge.data.remote.UserTokenService

class UserTokenRepository(private val service: UserTokenService) {

    suspend fun getUserToken(body: UserTokenBody) = when (
        val resource = safeApiCall { service.getUserToken(body) }
    ) {
        is Resource.Success -> resource.data.accessToken
        is Resource.Error -> ""
    }
}