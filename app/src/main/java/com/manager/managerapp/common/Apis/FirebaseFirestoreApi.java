package com.manager.managerapp.common.Apis;

import com.google.firebase.firestore.FirebaseFirestore;

public class FirebaseFirestoreApi {

    private static FirebaseFirestoreApi instance = null;
    private FirebaseFirestore db;

    private FirebaseFirestoreApi() {
        db = FirebaseFirestore.getInstance();
    }

    public static FirebaseFirestoreApi getInstance() {
        if (instance == null){
            instance = new FirebaseFirestoreApi();
        }
        return instance;
    }

    public FirebaseFirestore getFirestore(){
        return db;
    }
}
