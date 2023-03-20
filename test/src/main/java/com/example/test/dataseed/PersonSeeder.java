package com.example.test.dataseed;

import java.io.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.test.repository.PersonRepository;
import com.example.test.entity.PersonEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Arrays;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
     * personsテーブルへCSVを参照し、データ投入するロジック
     * ※イニシャライズ用の為、対象のテーブルにデータが存在する場合はログ出力して以降の処理は実行しない。
    */
	private void loadPersonData() {
        log.info("start person seeder");
        Boolean check_person_count = checkPersonData();
        if(check_person_count){
            log.debug("already exist person data");
            return;
        }
        BufferedReader br = null;
        String data_csv = "src/main/resources/csv/user-data.csv";
        try {
            File file = new File(data_csv);
            br = new BufferedReader(new FileReader(file));
            String line;
            String[] data;
            br.readLine();
            Integer cnt = 1;
            List<PersonEntity> entities = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                data = line.split(",");
                entities.add(new PersonEntity(cnt, data[0], data[1]));
                cnt++;
            }
            personRepository.saveAll(entities);
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

    /**
     * 対象テーブルにデータが存在するかチェックする関数
     */
    private boolean checkPersonData() {
        List<PersonEntity> persons = personRepository.findAll();
        Integer person_cnt = persons.size();
        if(person_cnt != 0){
            return true;
        }
        return false;
    }
}