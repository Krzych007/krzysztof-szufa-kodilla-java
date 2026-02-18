package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
    private final int userId;
    private final String userName;
    private final char sex;
    private final LocalDate birthday;
    private final int postQuantity;

    public ForumUser(int userId, String userName, char sex, LocalDate birthday, int postQuantity) {
        this.userId = userId;
        this.userName = userName;
        this.sex = sex;
        this.birthday = birthday;
        this.postQuantity = postQuantity;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public int getPostQuantity() {
        return postQuantity;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", postQuantity=" + postQuantity +
                '}';
    }
}
