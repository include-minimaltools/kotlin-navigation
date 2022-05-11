package com.example.laboratoriono5_6.Viewmodel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.laboratoriono5_6.model.pintura
import com.example.laboratoriono5_6.Network.Callback
import com.example.laboratoriono5_6.Network.FirestoreService

class galeriaViewmodel: ViewModel(){
    val firestoreService = FirestoreService()
    var listGaleria: MutableLiveData<List<pintura>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun refresh(){
        getFromFirebase()
    }
    fun getFromFirebase(){
        firestoreService.getGaleria(object: Callback<List<pintura>> {
            override fun onSuccess(result: List<pintura>?) {
                listGaleria.postValue(result)
                processFinished()
            }
            override fun onFailed(exception: Exception) {
                processFinished()
            }
        })
    }
    fun processFinished(){
        isLoading.value = true
    }
}

