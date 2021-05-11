package com.example.githubsearchandroid;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.githubsearchandroid.data.FavData.FavRepository;
import com.example.githubsearchandroid.data.logindata.UserRepo;
import com.google.firebase.auth.FirebaseUser;

public class MainActivityViewModel extends AndroidViewModel {
    private final UserRepo userRepo;
    private FavRepository favRepo;

    public MainActivityViewModel(Application app) {
        super(app);
        userRepo = UserRepo.getInstance(app);
        favRepo = FavRepository.getFavRepository();
    }

    public void init() {
        String userId = userRepo.getCurrentUser().getValue().getUid();
        favRepo.init(userId);
    }

    public LiveData<FirebaseUser> getCurrentUser() {
        return userRepo.getCurrentUser();
    }

    public void signOut() {
        userRepo.signOut();
    }
}
