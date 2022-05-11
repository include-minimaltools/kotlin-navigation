package com.example.laboratoriono5_6.Viewmodel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.laboratoriono5_6.model.artista
import com.example.laboratoriono5_6.Network.Callback
import com.example.laboratoriono5_6.Network.FirestoreService

class artistaViewmodel: ViewModel() {
    val firestoreService= FirestoreService()
    var listArtista: MutableLiveData<List<artista>> = MutableLiveData()
    var isLoading= MutableLiveData<Boolean>()

    fun refresh() {
        getFromFirebase()
    }
    fun getFromFirebase(){
        firestoreService.getArtistas(object : Callback<List<artista>> {
            override fun onSuccess(result:List<artista>?){
                listArtista.postValue(result)
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
