package com.retrofit.sparsh.retrofitnetworkcall

import androidx.lifecycle.MutableLiveData
import com.lottery.quico.utils.ApiClient
import com.lottery.quico.utils.ApiInterface
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
            headers: HashMap<String, String>,
            params: HashMap<String, String>,
            observable: MutableLiveData<String>
        ) {
            val apiService: ApiInterface =
                ApiClient.getClient(baseUrl).create(ApiInterface::class.java)

            val response = apiService.getRequest(endpoint, headers, params)
            if (response.isSuccessful) {
                observable!!.postValue(response.body())
            } else {
                observable!!.postValue(errorCode)
            }
        }
    }
}