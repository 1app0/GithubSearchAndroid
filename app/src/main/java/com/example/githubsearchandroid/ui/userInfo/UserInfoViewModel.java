package com.example.githubsearchandroid.ui.userInfo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.githubsearchandroid.data.GithubRepository;
import com.example.githubsearchandroid.data.githubapi.GithubUser;

public class UserInfoViewModel extends ViewModel {
    private GithubRepository repo;

    public UserInfoViewModel() {
        repo = GithubRepository.getInstance();
    }

    public LiveData<GithubUser> getSearchedUser() {
        return repo.getSearchedUser();
    }
}
