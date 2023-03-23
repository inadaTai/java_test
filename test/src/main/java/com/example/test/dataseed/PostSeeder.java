package com.example.test.dataseed;

import java.io.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.test.repository.PostRepository;
import com.example.test.entity.PostEntity;
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
import java.util.Date;
import java.time.LocalDateTime;
@Order(2)
@Component
public class PostSeeder implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(PersonSeeder.class);
   
    @PersistenceContext private EntityManager entityManager;    

    @Autowired
    PostRepository postRepository; 

    @Override
	public void run(String... args) throws Exception {
		loadPostData();
	}
    
    /**
     * postsテーブルへCSVを参照し、データ投入するロジック
     * ※イニシャライズ用の為、対象のテーブルにデータが存在する場合はログ出力して以降の処理は実行しない。
    */
	private void loadPostData() {
        log.info("start post seeder");
        Boolean check_post_count = checkPostData();
        if(check_post_count){
            log.info("already exist post data");
            return;
        }
        try {
            Integer cnt = 1;
            List<PostEntity> entities = new ArrayList<>();
            Faker faker = new Faker(new Locale("ja_JP"));
            for (int i = 0; i < 10; i++) {
                List<UserEntity> user = entityManager.createNativeQuery("SELECT * FROM users ORDER BY RAND() limit 1", UserEntity.class).getResultList();
                entities.add(new PostEntity
                    (
                        cnt,
                        user.get(0).getUserId(),
                        faker.lorem().fixedString(30),
                        faker.lorem().fixedString(100),
                        LocalDateTime.now()
                    )
                );
                cnt++;
            }
            postRepository.saveAll(entities);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ;
    }

    /**
     * 対象テーブルにデータが存在するかチェックする関数
     */
    private boolean checkPostData() {
        List<PostEntity> posts = postRepository.findAll();
        Integer post_cnt = posts.size();
        if(post_cnt != 0){
            return true;
        }
        return false;
    }
}