package com.example.test.dataseed;

import java.io.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.test.repository.PersonRepository;
import com.example.test.entity.PersonEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import java.lang.reflect.Array;
import java.util.Arrays;

@Component
public class PersonSeeder implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(PersonSeeder.class);
    
    @Autowired
    PersonRepository personRepository; 

    @Override
	public void run(String... args) throws Exception {
		loadPersonData();
	}
    
    /**
     * @see https://qiita.com/rubytomato@github/items/4f0c64eb9a24eaceaa6e
     * 毎日定期実行されるタスクです。
     * cronについては上記を参考にした。
    */
	private void loadPersonData() {
        log.info("start seeder");
        BufferedReader br = null;
        String data_csv = "src/main/resources/csv/user-data.csv";
        try {
            File file = new File(data_csv);
            br = new BufferedReader(new FileReader(file));
            String line;
            String[] data;
            br.readLine();
            List<PersonEntity> persons = personRepository.findAll();
            Integer person_cnt = persons.size();

            if(person_cnt != 0){
                log.info("already exist person data");
                return ;
            }
            //fixme:後でバルクインサートに修正をかける。
            Integer cnt = 1;
            while ((line = br.readLine()) != null) {
                data = line.split(",");
                // List<PersonEntity> entities = Arrays.asList(
                //     new PersonEntity(cnt, data[0], data[1])
                // );
                PersonEntity personEntity = new PersonEntity(cnt, data[0], data[1]);
                personRepository.save(personEntity);
                cnt++;
            }
            // personRepository.save(entities);
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