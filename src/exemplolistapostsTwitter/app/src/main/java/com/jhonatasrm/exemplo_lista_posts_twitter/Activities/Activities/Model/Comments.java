package com.jhonatasrm.exemplo_lista_posts_twitter.Activities.Activities.Model;

public class Comments {

    int profileImage;
    String name;
    String username;
    String hour;
    String textComment;
    int likes;
    int retweets;

    public Comments(int profileImage, String name, String username, String hour, String textComment,
                    int likes, int retweets) {
        this.profileImage = profileImage;
        this.name = name;
        this.username = username;
        this.hour = hour;
        this.textComment = textComment;
        this.likes = likes;
        this.retweets = retweets;
    }

    public int getProfileImage() {
        return profileImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public String getHour() {
        return hour;
    }

    public String getTextComment() {
        return textComment;
    }

    public int getLikes() {
        return likes;
    }

    public int getRetweets() {
        return retweets;
    }

}
