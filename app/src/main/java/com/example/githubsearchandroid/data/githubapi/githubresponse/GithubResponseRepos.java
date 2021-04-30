package com.example.githubsearchandroid.data.githubapi.githubresponse;

import com.example.githubsearchandroid.data.githubapi.githubdata.GithubRepo;

public class GithubResponseRepos {
    private String name;
    private int stargazers_count;
    private int watchers_count;
    private String language;
    private int forks_count;

    public GithubRepo getGithubRepo() {
        return new GithubRepo(name, stargazers_count, watchers_count, language, forks_count);
    }
}
