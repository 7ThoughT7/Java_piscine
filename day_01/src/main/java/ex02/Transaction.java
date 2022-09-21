package ex02;

import java.util.UUID;

public class Transaction {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    private UUID identifier;
    private User recipient;
    private User sender;
    private TransferCategory transferCategory;
    private Integer transferAmount;

    public Transaction() { }

    public Transaction(UUID identifier, User recipient, User sender, TransferCategory transferCategory, Integer transferAmount) {
        this.identifier = identifier;
        this.recipient = recipient;
        this.sender = sender;
        this.transferCategory = transferCategory;
        if (this.transferCategory == TransferCategory.CREDITS && transferAmount >= 0)
            this.transferAmount = 0;
        else if (this.transferCategory == TransferCategory.CREDITS && transferAmount < 0)
            this.transferAmount = transferAmount;
        else if (this.transferCategory == TransferCategory.DEBITS && transferAmount < 0)
            this.transferAmount = 0;
        else
            this.transferAmount = transferAmount;
    }


    public UUID getIdentifier() {
        return identifier;
    }

    public void setIdentifier(UUID identifier) {
        this.identifier = identifier;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public TransferCategory getTransferCategory() {
        return transferCategory;
    }

    public void setTransferCategory(TransferCategory transferCategory) {
        this.transferCategory = transferCategory;
    }

    public Integer getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(Integer transferAmount) {
        if (this.transferCategory == TransferCategory.CREDITS && transferAmount >= 0)
            this.transferAmount = 0;
        else if (this.transferCategory == TransferCategory.CREDITS && transferAmount < 0)
            this.transferAmount = transferAmount;
        else if (this.transferCategory == TransferCategory.DEBITS && transferAmount < 0)
            this.transferAmount = 0;
        else
            this.transferAmount = transferAmount;
    }

    public void checkTransactionalBalance(Integer transferAmount, TransferCategory transferCategory) {
        if (transferCategory == TransferCategory.CREDITS && transferAmount >= 0) {
            this.transferAmount = null;
            System.out.println(ANSI_RED + "Wrong transferAmount for CREDIT transaction" + ANSI_RESET);
        } else if (transferCategory == TransferCategory.CREDITS && transferAmount < 0) {
            this.transferAmount = transferAmount;
        } else if (transferCategory == TransferCategory.DEBITS && transferAmount < 0) {
            this.transferAmount = null;
            System.out.println(ANSI_RED + "Wrong transferAmount for DEBIT transaction" + ANSI_RESET);
        } else if (transferCategory == TransferCategory.DEBITS && transferAmount >= 0) {
            this.transferAmount = transferAmount;
        }
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
