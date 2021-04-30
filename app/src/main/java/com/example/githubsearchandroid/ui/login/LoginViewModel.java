package com.example.githubsearchandroid.ui.login;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.githubsearchandroid.data.logindata.UserRep;
import com.google.firebase.auth.FirebaseUser;

public class LoginViewModel extends AndroidViewModel {
    private final UserRep userRep;

    public LoginViewModel(Application app) {
        super(app);
        userRep = UserRep.getInstance(app);
    }

    public LiveData<FirebaseUser> getCurrentUser() {
        return userRep.getCurrentUser();
    }
}
