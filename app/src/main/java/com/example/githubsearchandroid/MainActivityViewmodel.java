package com.example.githubsearchandroid;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.githubsearchandroid.data.UserRep;
import com.google.firebase.auth.FirebaseUser;

public class MainActivityViewmodel extends AndroidViewModel {
    private final UserRep userRep;

    public MainActivityViewmodel(Application app) {
        super(app);
        userRep = UserRep.getInstance(app);
    }

    public LiveData<FirebaseUser> getCurrentUser() {
        return userRep.getCurrentUser();
    }

    public void signOut() {
        userRep.signOut();
    }
}
