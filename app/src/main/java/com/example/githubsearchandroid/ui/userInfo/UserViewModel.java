package com.example.githubsearchandroid.ui.userInfo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.githubsearchandroid.data.GithubRepository;
import com.example.githubsearchandroid.data.githubapi.githubdata.GithubRepo;
import com.example.githubsearchandroid.data.githubapi.githubdata.GithubUser;

import java.util.List;

public class UserViewModel extends ViewModel {
    private GithubRepository repo;

    public UserViewModel() {
        repo = GithubRepository.getInstance();
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
