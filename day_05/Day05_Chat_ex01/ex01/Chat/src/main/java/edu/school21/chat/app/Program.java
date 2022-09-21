package edu.school21.chat.app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Message;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.util.Optional;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        HikariDataSource datasource = getDataSource();
        Scanner scanner = new Scanner(System.in);
        MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl(datasource);

        System.out.println("Enter a message ID");
        System.out.print("->");
        if (scanner.hasNextInt()) {
            Long index = scanner.nextLong();
            Optional<Message> messageOptional = messagesRepository.findById(index);
            if (messageOptional.isPresent()) {
                System.out.println(messageOptional.get());
            } else {
                System.out.println("Message with ID " + index + " not found");
            }
        }
        datasource.close();
    }

    public static HikariDataSource getDataSource() {
        HikariDataSource datasource;
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        config.setUsername("postgres");
        config.setPassword("postgres");

        datasource = new HikariDataSource(config);
        return datasource;
    }

}
