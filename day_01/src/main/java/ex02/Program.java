package ex02;

public class Program {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[] args) {

        UserArrayList userArrayList = new UserArrayList();
        int newSize;
        User user;

        System.out.println(ANSI_GREEN + "Check new object" + ANSI_RESET);
        System.out.println(userArrayList);

        System.out.println(ANSI_GREEN + "Change array size" + ANSI_RESET);
        newSize = (int)(Math.random() * 2 + 20);
        System.out.println(ANSI_BLUE + "New array size = " + ANSI_RESET + newSize);
        for (int i = 0; i < newSize; i++) {
            user = new User("user " + i, i);
            userArrayList.addUser(user);
        }
        System.out.println(ANSI_GREEN + "Array with new size" + ANSI_RESET);
        System.out.println(userArrayList);

        System.out.println(ANSI_GREEN +  "Find user by id" + ANSI_RESET);
        System.out.println(userArrayList.getById(105));

        System.out.println(ANSI_GREEN +  "Find user by index" + ANSI_RESET);
        System.out.println(userArrayList.getByIndex(13));

        System.out.println(ANSI_GREEN +  "Check users count" + ANSI_RESET);
        System.out.println(userArrayList.getUsersCount());

        System.out.println(ANSI_GREEN +  "Check array max size" + ANSI_RESET);
        System.out.println(userArrayList.getSizeOfArray());
    }
}
