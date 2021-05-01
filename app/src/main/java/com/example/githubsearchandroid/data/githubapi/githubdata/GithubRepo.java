package com.example.githubsearchandroid.data.githubapi.githubdata;

public class GithubRepo {
    private String name;
    private int stargazers_count;
    private int watchers_count;
    private String language;
    private int forks_count;

    public GithubRepo(String name, int stargazers_count, int watchers_count, String language, int forks_count) {
        this.name = name;
        this.stargazers_count = stargazers_count;
        this.watchers_count = watchers_count;
        this.language = language;
        this.forks_count = forks_count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStargazers_count() {
        return stargazers_count;
    }

    public int getWatchers_count() {
        return watchers_count;
    }

    public String getLanguage() {
        return language;
    }

    public int getForks_count() {
        return forks_count;
    }
}
