package com.example.githubsearchandroid.data.githubapi.githubdata;

public class GithubUser {
    private String name;
    private String bio;
    private int numberOfRepos;
    private int numberOfFollowers;
    private String login;
    private String avatar_url;
    private int following;
    private String twitter_username;
    private String company;
    private String location;
    private String blog;

    public GithubUser(String login, String name, String bio, int numberOfRepos, int numberOfFollowers, String avatar_url,
                      int following, String twitter_username, String company, String location, String blog) {
        this.login = login;
        this.name = name;
        this.bio = bio;
        this.numberOfRepos = numberOfRepos;
        this.avatar_url = avatar_url;
        this.numberOfFollowers = numberOfFollowers;
        this.following = following;
        this.twitter_username = twitter_username;
        this.company = company;
        this.location = location;
        this.blog = blog;
    }

    public String getCompany() {
        return company;
    }

    public String getLocation() {
        return location;
    }

    public String getBlog() {
        return blog;
    }

    public String getTwitter_username() {
        return twitter_username;
    }

    public String getBio() {
        return bio;
    }

    public int getFollowing() {
        return following;
    }

    public int getNumberOfFollowers() {
        return numberOfFollowers;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfRepos() {
        return numberOfRepos;
    }
}
