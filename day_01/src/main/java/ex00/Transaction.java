package ex00;

import java.util.UUID;

enum TransferCategory {
	DEBIT,
	CREDIT,
}

public class Transaction {
	private UUID identifier;
	private User recipient;
	private User sender;
	private TransferCategory transferCategory;
	private Integer transferAmount;

	public Transaction(){}

	public Transaction(UUID identifier, User recipient, User sender, TransferCategory transferCategory, Integer transferAmount) {
		this.identifier = identifier;
		this.recipient = recipient;
		this.sender = sender;
		this.transferCategory = transferCategory;
		if (this.transferCategory == TransferCategory.CREDIT && transferAmount >= 0)
			this.transferAmount = 0;
		else if (this.transferCategory == TransferCategory.CREDIT && transferAmount < 0)
			this.transferAmount = transferAmount;
		else if (this.transferCategory == TransferCategory.DEBIT && transferAmount <= 0)
			this.transferAmount = 0;
		else
			this.transferAmount = transferAmount;
	}

	public UUID getIdentifier() { return identifier; }

	public void setIdentifier(UUID identifier) { this.identifier = identifier; }

	public User getRecipient() { return recipient; }

	public void setRecipient(User recipient) { this.recipient = recipient; }

	public User getSender() { return sender; }

	public void setSender(User sender) { this.sender = sender; }

	public TransferCategory getTransferCategory() { return transferCategory; }

	public void setTransferCategory(TransferCategory transferCategory) { this.transferCategory = transferCategory; }

	public Integer getTransferAmount() { return transferAmount; }

	public void transferOperation(TransferCategory transferCategory, Integer transferAmount){ }

	public void setTransferAmount(Integer transferAmount) {
		if (this.transferCategory == TransferCategory.CREDIT && transferAmount >= 0)
			this.transferAmount = 0;
		else if (this.transferCategory == TransferCategory.CREDIT && transferAmount < 0)
			this.transferAmount = transferAmount;
		else if (this.transferCategory == TransferCategory.DEBIT && transferAmount <= 0)
			this.transferAmount = 0;
		else
			this.transferAmount = transferAmount;
	}

	public void transactionCheck(Integer transferAmount, TransferCategory transferCategory){
		if (this.transferCategory == TransferCategory.CREDIT && transferAmount >= 0) {
			this.transferAmount = null;
			System.out.println("Error");
		}
		else if (this.transferCategory == TransferCategory.CREDIT && transferAmount < 0)
			this.transferAmount = transferAmount;
		else if (this.transferCategory == TransferCategory.DEBIT && transferAmount <= 0){
			this.transferAmount = null;
			System.out.println("Error");
		}
		else
			this.transferAmount = transferAmount;
	}

	@Override
	public String toString() {
		return "Transaction{" +
				"identifier=" + identifier +
				", recipient=" + recipient +
				", sender=" + sender +
				", transferCategory=" + transferCategory +
				", transferAmount=" + transferAmount +
				'}';
	}
}
