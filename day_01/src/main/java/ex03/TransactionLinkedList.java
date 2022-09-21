package ex03;

import java.util.UUID;

public class TransactionLinkedList implements TransactionsList {

    @Override
    public String toString() {
        return "TransactionLinkedList{" +
                "first=" + first +
                ", last=" + last +
                ", size=" + size +
                '}';
    }

    private static class Node<Transaction> {
        Transaction value;
        Node<Transaction> next;

        public Node(Transaction value) {
            this.value = value;
        }

        public Transaction getValue() {
            return value;
        }

        public void setValue(Transaction value) {
            this.value = value;
        }

        public Node<Transaction> getNext() {
            return next;
        }

        public void setNext(Node<Transaction> next) {
            this.next = next;
        }
    }

    public Node<Transaction> getFirst() {
        return first;
    }

    public void setFirst(Node<Transaction> first) {
        this.first = first;
    }

    public Node<Transaction> getLast() {
        return last;
    }

    public void setLast(Node<Transaction> last) {
        this.last = last;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private Node<Transaction> first;
    private Node<Transaction> last;
    private int size;

    public static class TransactionNotFoundException extends RuntimeException {
        public TransactionNotFoundException() {
            super("Not found transaction");
        }
    }

    @Override
    public void addTransaction(Transaction elements) {
        Node<Transaction> newNode = new Node<>(elements);
        if (size == 0) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    @Override
    public void deleteTransaction(UUID identifier) {
        if (lookup(identifier).equals(true)) {
            if (first.value.equals(identifier))
                first = first.next;
        }
            else {
            Node<Transaction> temp = first;
            while (temp.next != null) {
                if (temp.next.value.equals(identifier)) {
                    temp.next = temp.next.next;
                    break;
                } else {
                    temp = temp.next;
                }
            }
        }
        throw new TransactionNotFoundException();
    }

    @Override
    public Transaction[] toArray() {
        Transaction[] newTransaction = new Transaction[size];
        Node<Transaction> tempTransaction = first.getNext();
        if (tempTransaction.getValue() == null) {
            System.out.println("Illegal argument");
        }
        for (int i = 0; i < size; i++) {
            newTransaction[i] = tempTransaction.getValue();
        }
        return newTransaction;
    }

    public Object lookup(Object x) {
        Node<Transaction> temp = first;
        Boolean search = false;

        if (first.value == x)
            search = true;
        while (temp.next != null) {
            if (temp.value == x) {
                search = true;
            } else {
                temp = temp.next;
            }
        }
        return search;
    }
}
