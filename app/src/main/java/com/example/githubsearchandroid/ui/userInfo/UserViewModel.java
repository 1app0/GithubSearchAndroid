package com.example.githubsearchandroid.ui.userInfo;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.githubsearchandroid.data.FavData.FavRepository;
import com.example.githubsearchandroid.data.GithubRepository;
import com.example.githubsearchandroid.data.githubapi.githubdata.GithubRepo;
import com.example.githubsearchandroid.data.githubapi.githubdata.GithubUser;

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

    public void init() {
        //TODO figure out if the hassle to pass userid from mainactivity is worth it, or just use userRepo directly
    }

    public void saveFavUser(List<String> favList) {
        favRepo.saveFavList(favList);
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
}
