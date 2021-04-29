package com.example.githubsearchandroid.data.githubapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubApi {
    @GET("users/{username}")
    Call<GithubResponseUser> getUser(@Path("username") String username);

    @GET("users/{username}/repos")
    Call<List<GithubResponseRepos>> getReposForUser(@Path("username") String username);
}
