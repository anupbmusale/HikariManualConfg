package com.hikari.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.activation.DataSource;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.hikari.confg.util.DataSourceStore;
import com.hikari.confg.util.DataSourceUtil;

@Configuration
@EnableScheduling
public class ConnectionListener {
	private DataSourceUtil du;

	public ConnectionListener() {
		du = new DataSourceUtil();
	}
	@Scheduled(fixedRate = 1000)
	public void checkDatabaseConnection() {
		System.out.println("Checking connection...");
		try (Connection conn = du.getConnection("ABM-EMP")) {
			if (conn != null) {
				System.out.println("Connected to the database!");
			} else {
				System.out.println("Failed to make connection!");
			}

		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {
			System.err.format("Exception while check db connection..." + e);
		}
	}
}
