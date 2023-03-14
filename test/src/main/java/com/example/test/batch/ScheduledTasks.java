package com.example.test.batch;

import java.io.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.example.test.repository.PersonRepository;
import com.example.test.entity.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;

@Component

public class ScheduledTasks {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    @Autowired   
    PersonRepository personRepository; 
    
    /**
     * @see https://qiita.com/rubytomato@github/items/4f0c64eb9a24eaceaa6e
     * 毎月1日に定期実行されるタスクです。
     * cronについては上記を参考にした。
    */
    @Scheduled(cron = "0 0 0 1 * *", zone = "Asia/Tokyo")
	public void monthlyBatch() {
        log.info("monthly_data");
        return ;
	}
}