package com.example.githubsearchandroid.data.githubapi;

public class GithubUser {
    private String name;
    private String bio;
    private int numberOfRepos;

    public GithubUser(String name, String bio, int numberOfRepos) {
        this.name = name;
        this.bio = bio;
        this.numberOfRepos = numberOfRepos;
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
