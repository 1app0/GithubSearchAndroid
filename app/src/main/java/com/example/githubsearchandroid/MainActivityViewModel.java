package com.example.githubsearchandroid;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.githubsearchandroid.data.logindata.UserRep;
import com.google.firebase.auth.FirebaseUser;

public class MainActivityViewModel extends AndroidViewModel {
    private final UserRep userRep;

    public MainActivityViewModel(Application app) {
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
