package ex03;

import java.util.Arrays;

public class UserArrayList<T> implements UsersList<T> {

    private static int ARRAY_SIZE = 10;
    private User[] elementsOfArray = new User[ARRAY_SIZE];
    private int sizeOfArray;

    @Override
    public String toString() {
        return "UserArrayList{" +
                "elementsOfArray=" + Arrays.toString(elementsOfArray) +
                ", sizeOfArray=" + sizeOfArray +
                '}';
    }

    public static class UserNotFoundException extends RuntimeException {
        public UserNotFoundException(Integer userId) {
            super("Not found user by id: " + userId);
        }
    }

    @Override
    public void addUser(User user) {

        if (sizeOfArray == ARRAY_SIZE) {
            System.out.println("List is full");
            elementsOfArray = makeArrayGreatAgain(elementsOfArray);
            System.out.println("List is resize to 2");
        }
        if (user != null) {
            elementsOfArray[sizeOfArray] = user;
            sizeOfArray++;
        } else {
            System.out.println("Invalid argument");
        }
    }

    @Override
    public User getById(Integer userId) {

        for (int i = 0; i < elementsOfArray.length; i++) {
            if (elementsOfArray[i].getUserId().equals(userId)) {
                return elementsOfArray[i];
            } else
                throw new UserArrayList.UserNotFoundException(userId);
        }
       return null;
    }

    @Override
    public User getByIndex(int indexSearchElement) {
        if (indexSearchElement >= 0 && indexSearchElement < elementsOfArray.length) {
            return elementsOfArray[indexSearchElement];
        } else {
            return null;
        }
    }

    @Override
    public Integer getUsersCount() {
        return sizeOfArray;
    }

    private User[] makeArrayGreatAgain(User[] elementsOfArray) {
        int newCapacity = ARRAY_SIZE * 2;
        User[] newUserArrayList = new User[newCapacity];
        System.arraycopy(elementsOfArray, 0, newUserArrayList, 0, ARRAY_SIZE);
        elementsOfArray = newUserArrayList;
        ARRAY_SIZE = newCapacity;
        return elementsOfArray;
    }

    public int getSizeOfArray() {
        return elementsOfArray.length;
    }
}
