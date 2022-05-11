package com.example.laboratoriono5_6.Network
import com.example.laboratoriono5_6.model.artista
import com.example.laboratoriono5_6.model.evento
import com.example.laboratoriono5_6.model.pintura
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings

const val ARTISTA_COLLECTION_NAME="Artista"
const val EVENTO_COLLECTION_NAME="Evento"
const val GALERIA_COLLECTION_NAME="Galeria"

class FirestoreService  {
    val firebaseFirestore = FirebaseFirestore.getInstance()
    val settings = FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true).build()

    init{
        firebaseFirestore.firestoreSettings=settings
    }

    fun getArtistas(callback: Callback <List<artista>>) {
        firebaseFirestore.collection(ARTISTA_COLLECTION_NAME)
            .orderBy("artistaNombre")
            .get()
            .addOnSuccessListener { result ->
                for(doc in result) {
                    val list=result.toObjects(artista::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }
    fun getEventos(callback:Callback <List<evento>>) {
        firebaseFirestore.collection(EVENTO_COLLECTION_NAME)
            .orderBy("eventoLugar")
            .get()
            .addOnSuccessListener { result ->
                for(doc in result) {
                    val list=result.toObjects(evento::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }
    fun getGaleria(callback:Callback <List<pintura>>) {
        firebaseFirestore.collection(GALERIA_COLLECTION_NAME)
            .orderBy("artistaPintura")
            .get()
            .addOnSuccessListener { result ->
                for(doc in result) {
                    val list=result.toObjects(pintura::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }
}
