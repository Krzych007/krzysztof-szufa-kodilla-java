package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {

    private final List<ForumUser> theForumUsers = new ArrayList<>();

    public Forum() {
        theForumUsers.add(new ForumUser(1, "Albert", 'M', LocalDate.of(1997, 3, 21), 7));
        theForumUsers.add(new ForumUser(2, "Aleksandra", 'F', LocalDate.of(2005, 4, 22), 9));
        theForumUsers.add(new ForumUser(3, "Alfred", 'M', LocalDate.of(2012, 5, 23), 11));
        theForumUsers.add(new ForumUser(4, "Antonina", 'F', LocalDate.of(1981, 6, 25), 13));
        theForumUsers.add(new ForumUser(5, "Amadeusz", 'M', LocalDate.of(1958, 7, 26), 0));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(theForumUsers);
    }
}
