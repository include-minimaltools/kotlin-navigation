package com.example.laboratoriono5_6.Viewmodel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.laboratoriono5_6.model.evento
import com.example.laboratoriono5_6.Network.Callback
import com.example.laboratoriono5_6.Network.FirestoreService

class eventoViewmodel: ViewModel() {
    val firestoreService = FirestoreService()
    var listEvento: MutableLiveData<List<evento>> = MutableLiveData()
    var isLoading= MutableLiveData<Boolean>()

    fun refresh() {
        getFromFirebase()
    }
    fun getFromFirebase(){
        firestoreService.getEventos(object : Callback<List<evento>> {
            override fun onSuccess(result:List<evento>?){
                listEvento.postValue(result)
                processFinished()
            }
            override fun onFailed(exception: Exception){
                processFinished()
            }
        })
    }
    fun processFinished(){
        isLoading.value = true
    }
}
