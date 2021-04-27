package com.example.githubsearchandroid.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseUser;

public class UserRep {
    private final UserData currentUser;
    private final Application app;
    private static UserRep instance;

    private UserRep(Application app) {
        this.app = app;
        currentUser = new UserData();
    }

    public static synchronized UserRep getInstance(Application app) {
        if (instance == null) {
            instance = new UserRep(app);
        }
        return instance;
    }

    public LiveData<FirebaseUser> getCurrentUser() {
        return currentUser;
    }

    public void signOut() {
        AuthUI.getInstance().signOut(app.getApplicationContext());
    }
}
