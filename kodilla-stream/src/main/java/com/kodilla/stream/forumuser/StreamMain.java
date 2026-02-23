package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {

        Forum forum = new Forum();

        Map<Integer, ForumUser> resultMap = forum.getUserList().stream()
                .filter(forumUser -> forumUser.getSex() == 'M')
                .filter(forumUser -> !forumUser.getBirthday().isAfter(LocalDate.now().minusYears(20)))
                .filter(forumUser -> forumUser.getPostQuantity() > 0)
                .collect(Collectors.toMap(ForumUser::getUserId, Function.identity()));

        resultMap.forEach((id, user) -> System.out.println(id + " > " + user));
    }
}
