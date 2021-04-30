package com.example.githubsearchandroid.data.githubapi.githubdata;

public class GithubUser {
    private String name;
    private String bio;
    private int numberOfRepos;
    private String login;
    private String avatar_url;

    public GithubUser(String login, String name, String bio, int numberOfRepos, String avatar_url) {
        this.login = login;
        this.name = name;
        this.bio = bio;
        this.numberOfRepos = numberOfRepos;
        this.avatar_url = avatar_url;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public int getNumberOfRepos() {
        return numberOfRepos;
    }

    public void setNumberOfRepos(int numberOfRepos) {
        this.numberOfRepos = numberOfRepos;
    }
}
