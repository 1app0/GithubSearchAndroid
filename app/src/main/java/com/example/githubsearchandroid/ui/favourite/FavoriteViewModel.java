package com.example.githubsearchandroid.ui.favourite;

import androidx.lifecycle.ViewModel;

import com.example.githubsearchandroid.data.FavData.FavRepository;
import com.google.firebase.database.DatabaseReference;

public class FavoriteViewModel extends ViewModel {
    private FavRepository favRepo;

    public FavoriteViewModel() {
        favRepo = FavRepository.getFavRepository();
    }

    public DatabaseReference getDbRef() {
        return favRepo.getDbRef();
    }
}
