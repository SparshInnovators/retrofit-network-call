package com.lottery.quico.utils

import retrofit2.http.*

interface ApiInterface {

    /*GET requests starts*/

    @GET
    suspend fun getRequest(
        @Url url: String,
    ): retrofit2.Response<Any>

    @GET
    suspend fun getWithHeaderRequest(
        @Url url: String,
        @HeaderMap headers: Map<String, String>?,
    ): retrofit2.Response<Any>

    /*GET requests ends*/

    /*POST requests starts*/

    @POST
    suspend fun postRequest(
        @Url url: String,
    ): retrofit2.Response<Any>

    @POST
    suspend fun postWithHeaderRequest(
        @Url url: String,
        @FieldMap headers: Map<String, String>?
    ): retrofit2.Response<Any>

    @POST
    suspend fun postWithParamsRequest(
        @Url url: String,
        @FieldMap params: Map<String, String>?
    ): retrofit2.Response<Any>

    @POST
    suspend fun postWithHeaderAndParamsRequest(
        @Url url: String,
        @HeaderMap headers: Map<String, String>?,
        @FieldMap params: Map<String, String>?
    ): retrofit2.Response<Any>

    /*POST requests ends*/


    /*PUT requests starts*/
    @PUT
    suspend fun putWithHeaderAndParamsRequest(
        @Url url: String,
        @HeaderMap headers: Map<String, String>?,
        @Body params: Map<String, String>?
    ): retrofit2.Response<Any>

    /*PUT requests ends*/

}