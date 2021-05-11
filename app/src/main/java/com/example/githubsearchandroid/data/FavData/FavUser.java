package com.example.githubsearchandroid.data.FavData;

public class FavUser {
    private String favUsername;

    public FavUser() {}

    public FavUser(String favUsername) {
        this.favUsername = favUsername;
    }

    public String getBody() {
        return favUsername;
    }

    public void setBody(String favUsername) {
        this.favUsername = favUsername;
    }
}
