package ex03;

import java.util.UUID;

public interface TransactionsList {

    void addTransaction(Transaction elements);

    void deleteTransaction(UUID identifier);

    Transaction[] toArray();
}
