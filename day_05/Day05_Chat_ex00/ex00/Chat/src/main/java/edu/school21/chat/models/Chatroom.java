package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class Chatroom {
    private Long id;
    private String name;
    private String owner;
    private List<Message> chatroomMessages;
    private User createdRoom;
    private User userChatroom;

    public Chatroom(Long chatroomId, String name, String owner) {
        this.id = chatroomId;
        this.name = name;
        this.owner = owner;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chatroom)) return false;
        Chatroom chatroom = (Chatroom) o;
        return id.equals(chatroom.id) && name.equals(chatroom.name) && owner.equals(chatroom.owner) && chatroomMessages.equals(chatroom.chatroomMessages) && createdRoom.equals(chatroom.createdRoom) && userChatroom.equals(chatroom.userChatroom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, owner, chatroomMessages, createdRoom, userChatroom);
    }

    @Override
    public String toString() {
        return "Chatroom{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner='" + owner + '\'' +
                ", chatroomMessages=" + chatroomMessages +
                ", createdRoom=" + createdRoom +
                ", userChatroom=" + userChatroom +
                '}';
    }
}
