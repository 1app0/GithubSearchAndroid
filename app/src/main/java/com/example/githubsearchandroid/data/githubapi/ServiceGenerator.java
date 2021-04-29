package com.example.githubsearchandroid.data.githubapi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    private static GithubApi githubApi;

    public static GithubApi getGithubApi() {
        if (githubApi == null) {
            githubApi = new Retrofit.Builder()
                    .baseUrl("https://api.github.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(GithubApi.class);
        }

        return githubApi;
    }
}
