package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private List<User> users = new ArrayList<>();

    public UserService() {
        users.addAll(List.of(
                User.of(1, "User1"),
                User.of(2, "User2"),
                User.of(3, "User3")));
    }

    public List<User> getUsers() {
        return users;
    }

    public User findUserById(int id) {
        return users.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
    }
}
