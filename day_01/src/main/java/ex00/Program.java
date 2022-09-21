package ex00;

import java.util.UUID;

public class Program {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_GREEN = "\u001B[32m";

	public static void main(String[] args) {


		User firstUser = new User();
		firstUser.setIdentifier(1);
		firstUser.setName("Vasia");
		firstUser.setBalance(500);

		User secondUser = new User();
		secondUser.setIdentifier(2);
		secondUser.setName("Olga");
		secondUser.setBalance(400);

		Transaction transaction = new Transaction(UUID.randomUUID(), firstUser, secondUser, TransferCategory.CREDIT, -350);


		Transaction outcomeTransaction = new Transaction();
		outcomeTransaction.setIdentifier(UUID.randomUUID());
		outcomeTransaction.setRecipient(firstUser);
		outcomeTransaction.setSender(secondUser);
		outcomeTransaction.setTransferCategory(TransferCategory.DEBIT);
		outcomeTransaction.setTransferAmount(-200);

		Transaction incomeTransaction = new Transaction();
		incomeTransaction.setIdentifier(UUID.randomUUID());
		incomeTransaction.setRecipient(secondUser);
		incomeTransaction.setSender(firstUser);
		incomeTransaction.setTransferCategory(TransferCategory.CREDIT);
		incomeTransaction.setTransferAmount(300);

		printInformationAboutClass(firstUser, secondUser, outcomeTransaction, incomeTransaction);
		checkUsersBalance(firstUser, secondUser);
		checkTransactional(outcomeTransaction, incomeTransaction);
		}

	public static void printInformationAboutClass(User firstUser, User secondUser, Transaction outcomeTransaction, Transaction incomeTransaction) {
		System.out.println(ANSI_GREEN + "Information about USERS" + ANSI_RESET);

		System.out.println(firstUser.toString());
		System.out.println(secondUser.toString());

		System.out.println(ANSI_GREEN + "Information about TRANSACTIONS" + ANSI_RESET);

		System.out.println(outcomeTransaction.toString());
		System.out.println(incomeTransaction.toString());
	}

	public static void checkUsersBalance(User firstUser, User secondUser) {

		System.out.println(ANSI_GREEN + "Users balance" + ANSI_RESET);
		System.out.println(ANSI_BLUE + "firstUser balance BEFORE changes: " + ANSI_RESET + firstUser.getBalance());
		firstUser.setBalance(-300);
		System.out.println(ANSI_BLUE + "firstUser balance AFTER changes: " + ANSI_RESET + firstUser.getBalance());


		System.out.println(ANSI_BLUE + "secondUser balance BEFORE changes: " + ANSI_RESET + secondUser.getBalance());
		secondUser.setBalance(-80);
		System.out.println(ANSI_BLUE + "secondUser balance AFTER changes: " + ANSI_RESET + secondUser.getBalance());
	}

	public static void checkTransactional(Transaction outcomeTransaction, Transaction incomeTransaction) {
		System.out.println(ANSI_GREEN + "Transactional date" + ANSI_RESET);
		System.out.println(ANSI_BLUE + "outcomeTransaction balance BEFORE changes: " + ANSI_RESET + outcomeTransaction.getTransferAmount());
		outcomeTransaction.transactionCheck(300, outcomeTransaction.getTransferCategory());
		System.out.println(ANSI_BLUE + "outcomeTransaction balance AFTER changes: " + ANSI_RESET + outcomeTransaction.getTransferAmount());

		System.out.println(ANSI_BLUE + "incomeTransaction balance BEFORE changes: " + ANSI_RESET + incomeTransaction.getTransferAmount());
		incomeTransaction.transactionCheck(500, incomeTransaction.getTransferCategory());
		System.out.println(ANSI_BLUE + "incomeTransaction balance AFTER changes: " + ANSI_RESET + incomeTransaction.getTransferAmount());

	}
}
