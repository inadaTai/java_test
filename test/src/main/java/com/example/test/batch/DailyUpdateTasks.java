package com.example.test.batch;

import java.io.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component

public class DailyUpdateTasks {

	private static final Logger log = LoggerFactory.getLogger(WeeklyUpdateTasks.class);

    /**
     * @see https://qiita.com/rubytomato@github/items/4f0c64eb9a24eaceaa6e
     * 毎日に朝方5時に定期実行されるタスクです。
     * cronについては上記を参考にした。
    */
    @Scheduled(cron = "0 0 5 * * ?", zone = "Asia/Tokyo")
	public void dailyBatch() {
        log.info("Daily batch job started.");
        log.info("Daily batch job completed.");
        return ;
	}
}