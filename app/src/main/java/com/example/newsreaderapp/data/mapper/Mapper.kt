package com.example.newsreaderapp.data.mapper

import com.example.newsreaderapp.domain.model.ApiError
import com.example.newsreaderapp.domain.model.NetworkError
import okio.IOException
import retrofit2.HttpException

fun Throwable.toNetworkError() : NetworkError
{
    val error = when(this){
        is IOException -> ApiError.NetworkError
        is HttpException -> ApiError.UnknownResponse
        else -> ApiError.UnknownError
    }
    return NetworkError(
        error =error,
        t =this
    )
}