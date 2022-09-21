package ex03;

public class UserIdsGenerator {

    public static final  UserIdsGenerator instance;
    public static int index = 0;

    static {
        instance = new UserIdsGenerator();
    }

    public static UserIdsGenerator getInstance() {
        return instance;
    }

    private UserIdsGenerator() {

    }

    public int generateId() {
        index++;
        return index;
    }
}
