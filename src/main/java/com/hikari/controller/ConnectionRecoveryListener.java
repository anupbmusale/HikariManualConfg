package com.hikari.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.hikari.confg.util.DataSourceUtil;

@Configuration
@EnableScheduling
public class ConnectionRecoveryListener {
	private DataSourceUtil du;

	public ConnectionRecoveryListener() {
		du = new DataSourceUtil();
	}

	@Scheduled(fixedRate = 15000)
	public void removeConnection() {
		try {
			System.out.println("try for remove connection...");
			du.removePool("ABM-EMP");
		} catch (Exception ex) {
			System.out.println("Exception while removing connection...");
		}
	}
}
