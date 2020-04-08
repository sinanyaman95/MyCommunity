package com.humber.saynn.mycommunity.entities;

import java.util.List;

public class User {

    private String username;
    private String comment;
    private List<String> nationalities;
    private List<String> communities;

    public User(String username, String comment) {
        new User(username,comment,null,null);
    }

    public User(String username, String comment, List<String> nationalities, List<String> communities) {
        this.username = username;
        this.comment = comment;
        this.nationalities = nationalities;
        this.communities = communities;
    }

    public List<String> getNationalities() {
        return nationalities;
    }

    public void addNationality(String s) {
        getNationalities().add(s);
    }

    public List<String> getCommunities() {
        return communities;
    }

    public void addCommunity(String s) {
        getCommunities().add(s);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
