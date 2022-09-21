package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class User {
    private Long userId;
    private String login;
    private String password;
    private List<Chatroom> createdRooms;
    private List<Chatroom> usersChatroom;

    public User(Long userId, String login, String password) {
        this.userId = userId;
        this.login = login;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return userId.equals(user.userId) && login.equals(user.login) && password.equals(user.password) && createdRooms.equals(user.createdRooms) && usersChatroom.equals(user.usersChatroom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, login, password, createdRooms, usersChatroom);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", createdRooms=" + createdRooms +
                ", usersChatroom=" + usersChatroom +
                '}';
    }
}
