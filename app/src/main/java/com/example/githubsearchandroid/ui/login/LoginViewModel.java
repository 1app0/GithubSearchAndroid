package com.example.githubsearchandroid.ui.login;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.githubsearchandroid.data.logindata.UserRepo;
import com.google.firebase.auth.FirebaseUser;

public class LoginViewModel extends AndroidViewModel {
    private final UserRepo userRepo;

    public LoginViewModel(Application app) {
        super(app);
        userRepo = UserRepo.getInstance(app);
    }

    public LiveData<FirebaseUser> getCurrentUser() {
        return userRepo.getCurrentUser();
    }
}
