package com.example.githubsearchandroid.data.githubapi.githubresponse;

import com.example.githubsearchandroid.data.githubapi.githubdata.GithubUser;

public class GithubResponseUser {
    private String login;
    private String name;
    private String bio;
    private int public_repos;
    private String avatar_url;

    public GithubUser getGithubUser() {
        return new GithubUser(login, name, bio, public_repos, avatar_url);
    }
}
