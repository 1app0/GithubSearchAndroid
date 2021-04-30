package com.example.githubsearchandroid.data;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.githubsearchandroid.data.githubapi.GithubApi;
import com.example.githubsearchandroid.data.githubapi.githubdata.GithubRepo;
import com.example.githubsearchandroid.data.githubapi.githubresponse.GithubResponseRepos;
import com.example.githubsearchandroid.data.githubapi.githubresponse.GithubResponseUser;
import com.example.githubsearchandroid.data.githubapi.githubdata.GithubUser;
import com.example.githubsearchandroid.data.githubapi.ServiceGenerator;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GithubRepository {
    public static GithubRepository instance;
    private final MutableLiveData<GithubUser> searchedUser;
    private final MutableLiveData<List<GithubRepo>> searchedRepos;

    private List<GithubRepo> githubReposList;

    public GithubRepository() {
        searchedUser = new MutableLiveData<>();
        searchedRepos = new MutableLiveData<>();
    }

    public static synchronized GithubRepository getInstance() {
        if (instance == null) {
            instance = new GithubRepository();
        }

        return instance;
    }

    public LiveData<GithubUser> getSearchedUser() {
        return searchedUser;
    }

    public LiveData<List<GithubRepo>> getSearchedRepos() {
        return searchedRepos;
    }

    public void searchForRepos(String username) {
        GithubApi githubApi = ServiceGenerator.getGithubApi();
        Call<List<GithubResponseRepos>> call = githubApi.getReposForUser(username);
        call.enqueue(new Callback<List<GithubResponseRepos>>() {
            @Override
            public void onResponse(Call<List<GithubResponseRepos>> call, Response<List<GithubResponseRepos>> response) {
                if (response.isSuccessful()) { ;
                    githubReposList= new ArrayList<>();

                    for (GithubResponseRepos repoResponse : response.body()) {
                        githubReposList.add(repoResponse.getGithubRepo());
                    }

                    searchedRepos.postValue(githubReposList);
                }
            }

            @Override
            public void onFailure(Call<List<GithubResponseRepos>> call, Throwable t) {
                Log.i("Retrofit", t.getMessage());
            }
        });
    }

    public void searchForUser(String username) {
        GithubApi githubApi = ServiceGenerator.getGithubApi();
        Call<GithubResponseUser> call = githubApi.getUser(username);
        call.enqueue(new Callback<GithubResponseUser>() {
            @Override
            public void onResponse(Call<GithubResponseUser> call, Response<GithubResponseUser> response) {
                if (response.isSuccessful()) {
                    searchedUser.postValue(response.body().getGithubUser());
                }
            }

            @Override
            public void onFailure(Call<GithubResponseUser> call, Throwable t) {
                Log.i("Retrofit", t.getMessage());
            }
        });
    }
}
