package com.pomelocardsreactnativedemo.bridge.data.remote

import com.pomelocardsreactnativedemo.bridge.data.entities.UserTokenBody
import com.pomelocardsreactnativedemo.bridge.data.entities.UserTokenResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserTokenService {
    @POST("token")
    suspend fun getUserToken(
        @Body body: UserTokenBody
    ): Response<UserTokenResponse>
}
