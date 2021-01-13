package com.manager.managerapp.repository;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.manager.managerapp.common.Apis.FirebaseFirestoreApi;
import com.manager.managerapp.common.pojo.Email;

public class repositoryFirebase {

    FirebaseFirestoreApi dataBase;

    public repositoryFirebase() {
        dataBase = FirebaseFirestoreApi.getInstance();
    }

    public void addEmailVinculado(Email email) {
        dataBase.getFirestore().collection("email").add(email).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
    }
}
