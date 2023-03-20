package com.example.test.batch;

import java.io.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component

public class WeeklyUpdateTasks {

	private static final Logger log = LoggerFactory.getLogger(WeeklyUpdateTasks.class);

    @Autowired   
    
    /**
     * @see https://qiita.com/rubytomato@github/items/4f0c64eb9a24eaceaa6e
     * 毎週月曜日に定期実行されるタスクです。
     * cronについては上記を参考にした。
    */
    @Scheduled(cron = "0 0 0 ? * MON", zone = "Asia/Tokyo")
	public void weeklyBatch() {
        log.info("Weekly batch job started.");

        log.info("Weekly batch job completed.");
        return ;
	}
}