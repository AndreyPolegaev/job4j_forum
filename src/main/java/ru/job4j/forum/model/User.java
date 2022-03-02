package ru.job4j.forum.model;

public class User {

    private int id;
    private String name;

    public static User of(int id, String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        return user;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
