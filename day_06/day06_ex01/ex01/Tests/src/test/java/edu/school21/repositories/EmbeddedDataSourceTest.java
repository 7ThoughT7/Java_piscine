package edu.school21.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EmbeddedDataSourceTest {
	private EmbeddedDatabase db;

	@BeforeEach
	void init(){
	 db = new EmbeddedDatabaseBuilder()
			.generateUniqueName(true)
			.setType(EmbeddedDatabaseType.HSQL)
			.setScriptEncoding("UTF-8")
			.ignoreFailedDrops(true)
			.addScript("schema.sql")
			.addScript("data.sql")
			.build();
	}

	@Test
	void getConnection(){
		Connection connection = null;

		try {
			connection = db.getConnection();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			return;
		}

		assertNotNull(connection);
		db.shutdown();
	}

}
