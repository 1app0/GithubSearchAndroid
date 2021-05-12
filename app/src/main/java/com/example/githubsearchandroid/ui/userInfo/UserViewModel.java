package com.example.githubsearchandroid.ui.userInfo;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.githubsearchandroid.data.FavData.FavRepository;
import com.example.githubsearchandroid.data.FavData.FavUser;
import com.example.githubsearchandroid.data.GithubRepository;
import com.example.githubsearchandroid.data.githubapi.githubdata.GithubRepo;
import com.example.githubsearchandroid.data.githubapi.githubdata.GithubUser;
import com.example.githubsearchandroid.data.logindata.UserRepo;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;


import java.util.List;

public class UserViewModel extends AndroidViewModel {
    private GithubRepository repo;
    private List<GithubRepo> githubRepos;
    private FavRepository favRepo;


    public UserViewModel(Application app) {
        super(app);
        repo = GithubRepository.getInstance();
        githubRepos = repo.getGithubReposList();
        favRepo = FavRepository.getFavRepository();
    }

    public void saveFavUser(String username) {
        FavUser favUser = new FavUser(username);
        favRepo.saveFav(favUser);
    }

    public DatabaseReference getDbRef() {
        return favRepo.getDbRef();
    }

    public LiveData<GithubUser> getSearchedUser() {
        return repo.getSearchedUser();
    }

    public LiveData<List<GithubRepo>> getSearchedRepos() {
        return repo.getSearchedRepos();
    }

    public void searchRepos(String username) {
        repo.searchForRepos(username);
    }

    public void searchUser(String username) {
        repo.searchForUser(username);
    }
}
