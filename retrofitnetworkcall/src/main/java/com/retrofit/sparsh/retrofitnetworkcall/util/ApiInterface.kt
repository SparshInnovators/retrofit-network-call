package com.lottery.quico.utils

import retrofit2.http.*

interface ApiInterface {

    /*GET requests starts*/

    @GET
    suspend fun getRequest(
        @Url url: String,
    ): retrofit2.Response<String>

    @GET
    suspend fun getWithHeaderRequest(
        @Url url: String,
        @HeaderMap headers: Map<String, String>?,
    ): retrofit2.Response<String>

    /*GET requests ends*/

    /*POST requests starts*/

    @POST
    suspend fun postRequest(
        @Url url: String,
    ): retrofit2.Response<String>

    @POST
    suspend fun postWithHeaderRequest(
        @Url url: String,
        @HeaderMap headers: Map<String, String>?
    ): retrofit2.Response<String>

    @POST
    suspend fun postWithParamsRequest(
        @Url url: String,
        @Body params: Map<String, String>?
    ): retrofit2.Response<String>

    @POST
    suspend fun postWithHeaderAndParamsRequest(
        @Url url: String,
        @HeaderMap headers: Map<String, String>?,
        @Body params: Map<String, String>?
    ): retrofit2.Response<String>

    /*POST requests ends*/

}