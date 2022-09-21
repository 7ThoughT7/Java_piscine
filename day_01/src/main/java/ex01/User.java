package ex01;

public class User {
	private Integer identifier;
	private String name;
	private Integer balance;

	public User(){this.identifier = UserIdsGenerator.getInstance().generateId();}

	public User(Integer identifier, String name, Integer balance) {
		this.identifier = identifier;
		this.name = name;
		if (balance < 0)
			this.balance = 0;
		else
			this.balance = balance;
	}

	public User(String name, Integer balance) {
		this.identifier = UserIdsGenerator.getInstance().generateId();
		this.setName(name);
		this.setBalance(200);
	}

	public Integer getIdentifier() { return identifier; }

	public void setIdentifier(Integer identifier) {
		this.identifier = identifier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		if (balance < 0)
			this.balance = 0;
		else
			this.balance = balance;
	}

	@Override
	public String toString() {
		return "User: " +
				"identifier=" + identifier +
				", name=" + name +
				", balance=" + balance;
	}


}
