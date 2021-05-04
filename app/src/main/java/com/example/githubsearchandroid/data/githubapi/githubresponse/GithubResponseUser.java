package com.example.githubsearchandroid.data.githubapi.githubresponse;

import com.example.githubsearchandroid.data.githubapi.githubdata.GithubUser;

public class GithubResponseUser {
    private String login;
    private String name;
    private String bio;
    private int public_repos;
    private int followers;
    private String avatar_url;
    private int following;
    private String twitter_username;
    private String company;
    private String location;
    private String blog;

    public GithubUser getGithubUser() {
        return new GithubUser(login, name, bio, public_repos, followers, avatar_url, following,
                twitter_username, company, location, blog);
    }
}
