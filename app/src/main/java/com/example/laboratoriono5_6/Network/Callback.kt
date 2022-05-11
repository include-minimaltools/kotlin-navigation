package com.example.laboratoriono5_6.Network

interface Callback<T>{
    fun onSuccess(result: T?)
    fun onFailed(exception: Exception)

}