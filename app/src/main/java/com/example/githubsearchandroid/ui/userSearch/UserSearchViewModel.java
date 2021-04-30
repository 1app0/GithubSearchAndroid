package com.example.githubsearchandroid.ui.userSearch;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.githubsearchandroid.data.GithubRepository;
import com.example.githubsearchandroid.data.githubapi.githubdata.GithubUser;

public class UserSearchViewModel extends ViewModel {
    private GithubRepository repo;

    public UserSearchViewModel() {
        repo = GithubRepository.getInstance();
    }

    public LiveData<GithubUser> getSearchedUser() {
        return repo.getSearchedUser();
    }

    public void searchForUser(String username) {
        repo.searchForUser(username);
    }
}
