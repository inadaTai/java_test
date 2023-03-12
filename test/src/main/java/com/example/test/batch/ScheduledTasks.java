package com.example.test.batch;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.test.repository.PersonRepository;
import com.example.test.entity.PersonEntity;

@Component

public class ScheduledTasks {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    @Autowired   
    PersonRepository personRepository; 

    /**
     * @see https://qiita.com/rubytomato@github/items/4f0c64eb9a24eaceaa6e
     * 毎日定期実行されるタスクです。
     * cronについては上記を参考にした。
    */
    @Scheduled(fixedDelay = 10000)
	public void reportCurrentTime() {
        BufferedReader br = null;
        String data_csv = "src/main/resources/csv/user-data.csv";
        try {
            File file = new File(data_csv);
            br = new BufferedReader(new FileReader(file));
            String line;
            String[] data;
            br.readLine();
            Integer cnt = 1;
            while ((line = br.readLine()) != null) {
                data = line.split(",");
                PersonEntity newEntity = new PersonEntity(cnt, data[0], data[1]);
                personRepository.save(newEntity);
                cnt++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return ;
	}
}