package ex03;

public class User {
    private final Integer userId;
    private String userName;
    private Integer userBalance;
    private TransactionsList list;

    public User(String userName, Integer userBalance) {
        this.userId = UserIdsGenerator.getInstance().generateId();
        this.setUserName("Vasia");
        this.setUserBalance(250);
        this.list = new TransactionLinkedList();
    }

    public User() {
        this.userId = UserIdsGenerator.getInstance().generateId();
    }

    public User(Integer userId, String userName, Integer userBalance) {
        this.userId = UserIdsGenerator.getInstance().generateId();
        this.userName = userName;
        this.userBalance = userBalance;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(Integer userBalance) {
        if (userBalance < 0) {
            this.userBalance = 0;
        }
        else {
            this.userBalance = userBalance;
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userBalance=" + userBalance +
                '}';
    }

    public void setList(TransactionsList list) {
        this.list = list;
    }
}
