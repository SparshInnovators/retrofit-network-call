package com.retrofit.sparsh.retrofitnetworkcall

import androidx.lifecycle.MutableLiveData
import com.lottery.quico.utils.ApiClient
import com.lottery.quico.utils.ApiInterface
import retrofit2.Response
import java.util.*

/**
 * Created by Rahul Sharma on 05-02-2021.
 */
class RetrofitNetworkCall {

    companion object {
        var errorCode = "201"

        suspend fun initNetworkCall(
            baseUrl: String,
            endpoint: String,
            headers: HashMap<String, String>?,
            params: HashMap<String, String>?,
            observable: MutableLiveData<String>,
            type: String
        ) {
            val apiService: ApiInterface =
                ApiClient.getClient(baseUrl).create(ApiInterface::class.java)
            var response: Response<String>? = null

            if (type.equals("get", ignoreCase = true)) {

                if ((headers != null) && (params != null)) {
                    response =
                        apiService.getWithHeaderRequest(endpoint + "/" + params, headers)
                }
                if ((headers != null) && (params == null)) {
                    response = apiService.getWithHeaderRequest(endpoint, headers)
                }
                if ((headers == null) && (params != null)) {
                    response = apiService.getRequest(endpoint + "/" + params)
                }
                if ((headers == null) && (params == null)) {
                    response = apiService.getRequest(endpoint)
                }
            }
            if (type.equals("post", ignoreCase = true)) {

                if ((headers != null) && (params != null)) {
                    response = apiService.postWithHeaderAndParamsRequest(endpoint, headers, params)
                }
                if ((headers != null) && (params == null)) {
                    response = apiService.postWithHeaderRequest(endpoint, headers)
                }
                if ((headers == null) && (params != null)) {
                    response = apiService.postWithParamsRequest(endpoint, params)
                }
                if ((headers == null) && (params == null)) {
                    response = apiService.postRequest(endpoint)
                }
            }


            if (response!!.isSuccessful) {
                observable!!.postValue(response.body())
            } else {
                observable!!.postValue(errorCode)
            }
        }
    }
}