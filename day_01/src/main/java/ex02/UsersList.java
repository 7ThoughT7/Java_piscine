package ex02;

import java.util.List;

public interface UsersList<T> {

    void addUser(User user);

    User getById(Integer userId);

    User getByIndex(int indexSearchElement);

    Integer getUsersCount();
}
