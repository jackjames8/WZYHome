package com.WZYHome.Study.Demo;

/**
 * Created by Administrator on 2017/6/12.
 */

public class User {
    private String userName;
    private int userScore;
    public User() {
        super();
    }

    public User(String userName, int userScore) {
        this.userName = userName;
        this.userScore = userScore;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserScore() {
        return userScore;
    }

    public void setUserScore(int userScore) {
        this.userScore = userScore;
    }
}
