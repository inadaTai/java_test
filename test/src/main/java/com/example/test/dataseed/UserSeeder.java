package com.example.test.dataseed;

import java.io.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.test.repository.UserRepository;
import com.example.test.entity.UserEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Arrays;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import com.github.javafaker.Faker;
import java.util.Locale;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;


@Order(1)
@Component
public class UserSeeder implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(UserSeeder.class);
    
    @PersistenceContext private EntityManager entityManager;    
    
    @Autowired
    UserRepository userRepository; 

    @Override
	public void run(String... args) throws Exception {
		loadUserData();
	}
    
    /**
     * usersテーブルへCSVを参照し、データ投入するロジック
     * ※イニシャライズ用の為、対象のテーブルにデータが存在する場合はログ出力して以降の処理は実行しない。
    */
	private void loadUserData() {
        log.info("start user seeder");
        Boolean check_user_count = checkUserData();
        if(check_user_count){
            log.info("already exist user data");
            return;
        }
        try {
            Integer cnt = 1;
            List<UserEntity> entities = new ArrayList<>();
            Faker faker = new Faker(new Locale("ja_JP"));;
            for (int i = 0; i < 5; i++) {
                String email_head_str = "test" + i;
                entities.add(new UserEntity
                    (
                        cnt,
                        faker.name().fullName(),
                        faker.internet().safeEmailAddress(email_head_str),
                        faker.internet().password()
                    )
                );
                cnt++;
            }
            userRepository.saveAll(entities);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ;
    }

    /**
     * 対象テーブルにデータが存在するかチェックする関数
     */
    private boolean checkUserData() {
        List<UserEntity> users = userRepository.findAll();
        Integer user_cnt = users.size();
        if(user_cnt != 0){
            return true;
        }
        return false;
    }
}