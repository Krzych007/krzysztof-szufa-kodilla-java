package com.kodilla.testing.forum.statistics;

import java.util.List;

public class StatisticCalculator {

    private int usersCount;
    private int postsCount;
    private int commentsCount;

    private double avgPostsPerUser;
    private double avgCommentsPerUser;
    private double avgCommentsPerPost;

    public void calculateAdvStatistics(Statistics statistics) {
        this.usersCount = statistics.usersNames().size();
        this.postsCount = statistics.postsCount();
        this.commentsCount = statistics.commentsCount();

        this.avgPostsPerUser = (usersCount == 0) ? 0.0 : (double) postsCount / usersCount;
        this.avgCommentsPerUser = (usersCount == 0) ? 0.0 : (double) commentsCount / usersCount;
        this.avgCommentsPerPost = (postsCount == 0) ? 0.0 : (double) commentsCount / postsCount;
    }

    void showStatistics() {

    }

    public int getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(int usersCount) {
        this.usersCount = usersCount;
    }

    public int getPostsCount() {
        return postsCount;
    }

    public void setPostsCount(int postsCount) {
        this.postsCount = postsCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    public double getAvgPostsPerUser() {
        return avgPostsPerUser;
    }

    public void setAvgPostsPerUser(double avgPostsPerUser) {
        this.avgPostsPerUser = avgPostsPerUser;
    }

    public double getAvgCommentsPerUser() {
        return avgCommentsPerUser;
    }

    public void setAvgCommentsPerUser(double avgCommentsPerUser) {
        this.avgCommentsPerUser = avgCommentsPerUser;
    }

    public double getAvgCommentsPerPost() {
        return avgCommentsPerPost;
    }

    public void setAvgCommentsPerPost(double avgCommentsPerPost) {
        this.avgCommentsPerPost = avgCommentsPerPost;
    }
}
