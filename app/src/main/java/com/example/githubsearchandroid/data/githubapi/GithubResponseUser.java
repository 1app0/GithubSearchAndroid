package com.example.githubsearchandroid.data.githubapi;

public class GithubResponseUser {
    private String login;
    private String name;
    private String bio;
    private int public_repos;

    public GithubUser getGithubUser() {
        return new GithubUser(name, bio, public_repos);
    }
}
