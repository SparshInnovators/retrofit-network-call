package com.lottery.quico.utils

import retrofit2.http.*

interface ApiInterface {

    @GET
    suspend fun getRequest(
        @Url url: String,
        @HeaderMap headers: Map<String, String>,
        @Body params: Map<String, String>
    ): retrofit2.Response<String>

    @POST
    suspend fun postRequest(
        @Url url: String,
        @HeaderMap headers: Map<String, String>,
        @Body params: Map<String, String>
    ): retrofit2.Response<String>

}