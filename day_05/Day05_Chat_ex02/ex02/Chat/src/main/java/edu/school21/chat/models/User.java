package edu.school21.chat.models;

import java.util.ArrayList;
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

    public User(long userId, String user, String user1, ArrayList arrayList, ArrayList arrayList1) {
        this.userId = userId;
        this.login = user;
        this.password = user1;
        this.createdRooms = arrayList;
        this.usersChatroom = arrayList1;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Chatroom> getCreatedRooms() {
        return createdRooms;
    }

    public void setCreatedRooms(List<Chatroom> createdRooms) {
        this.createdRooms = createdRooms;
    }

    public List<Chatroom> getUsersChatroom() {
        return usersChatroom;
    }

    public void setUsersChatroom(List<Chatroom> usersChatroom) {
        this.usersChatroom = usersChatroom;
    }
}
