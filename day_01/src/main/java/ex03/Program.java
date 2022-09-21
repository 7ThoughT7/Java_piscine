package ex03;

import java.util.UUID;

public class Program {
    public static void main(String[] args) {

        int newSize;

        System.out.println("Change list size");
        newSize = (int) (Math.random() * 2 + 20);
        System.out.println("New list size = " + newSize);

        TransactionLinkedList transactionLinkedList = new TransactionLinkedList();
        User userSender = new User();
        userSender.setUserName("Masha");
        userSender.setUserBalance(270);
        User userRecipient = new User("Sasha", 290);
        userRecipient.setUserName("Sasha");
        userRecipient.setUserBalance(290);

        for (int i = 0; i < newSize; i++) {
            Transaction temp;
            if (i % 2 == 0) {
                temp = new Transaction(userSender, userRecipient, 265);
                temp.setIdentifier(UUID.randomUUID());
            } else {
                temp = new Transaction(userRecipient, userSender, 265);
                temp.setIdentifier(UUID.randomUUID());
            }
            transactionLinkedList.addTransaction(temp);
            System.out.println(transactionLinkedList);
        }


        System.out.println("Print list");
        for (Transaction t : transactionLinkedList.toArray()) {
            System.out.println(t.toString());
        }
        
        for (int i = 0; i < transactionLinkedList.getSize(); i++) {
            if (UUID.randomUUID().equals(transactionLinkedList.getFirst())) {
                transactionLinkedList.deleteTransaction(UUID.randomUUID());
                System.out.println("Element deleted");
                break;
            }
        }
    }
}
