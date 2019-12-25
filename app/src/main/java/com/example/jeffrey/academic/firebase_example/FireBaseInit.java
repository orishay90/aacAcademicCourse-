package com.example.jeffrey.academic.firebase_example;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.example.jeffrey.academic.firebase_example.firebase_users_data_add_data_change.FireBaseExmaple;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.Collections;
import java.util.List;

public class FireBaseInit  {

    private static FireBaseInit fireBaseInit = null;
    public FirebaseUser user;

    public List<AuthUI.IdpConfig> providers = Collections.singletonList(

            new AuthUI.IdpConfig.GoogleBuilder().build());
    private FirebaseStorage storage;

    private StorageReference storageRef;
    private FirebaseFirestore database;
    private Context context;


    private FireBaseInit(Context context){
        this.context=context;

        defineTheFireBaseDataBase();
        defineTheFireBaseUser();
        defineTheStorageReferance();
    }

    private void defineTheStorageReferance() {
        storage = FirebaseStorage.getInstance();
        storageRef=storage.getReference();
    }

    private void defineTheFireBaseUser() {
        user= FirebaseAuth.getInstance().getCurrentUser();
    }

    private void defineTheFireBaseDataBase() {
            // TODO: 13/12/2018 מתודה שמאתחלת את האובייקט שלנו מסוג פיירבייס עם הגדרות נחוצות
            database = FirebaseFirestore.getInstance();
            FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                    .setTimestampsInSnapshotsEnabled(true)
                    .build();
            database.setFirestoreSettings(settings);


    }



    public static FireBaseInit getInstance(Context context)
    {
        if (fireBaseInit == null)
            fireBaseInit = new FireBaseInit(context);

        return fireBaseInit;
    }


    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public static FireBaseInit getFireBaseInit() {
        return fireBaseInit;
    }

    public static void setFireBaseInit(FireBaseInit fireBaseInit) {
        FireBaseInit.fireBaseInit = fireBaseInit;
    }

    public FirebaseUser getUser() {
        return user;
    }

    public void setUser(FirebaseUser user) {
        this.user = user;
    }

    public List<AuthUI.IdpConfig> getProviders() {
        return providers;
    }

    public void setProviders(List<AuthUI.IdpConfig> providers) {
        this.providers = providers;
    }

    public FirebaseStorage getStorage() {
        return storage;
    }

    public void setStorage(FirebaseStorage storage) {
        this.storage = storage;
    }

    public StorageReference getStorageRef() {
        return storageRef;
    }

    public void setStorageRef(StorageReference storageRef) {
        this.storageRef = storageRef;
    }

    public FirebaseFirestore getDatabase() {
        return database;
    }

    public void setDatabase(FirebaseFirestore database) {
        this.database = database;
    }
}
