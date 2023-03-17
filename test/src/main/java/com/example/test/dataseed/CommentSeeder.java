package com.example.test.dataseed;

import java.io.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.test.repository.CommentRepository;
import com.example.test.entity.CommentEntity;
import com.example.test.entity.UserEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Arrays;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.github.javafaker.Faker;
import java.util.Locale;

@Component
public class CommentSeeder implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(PersonSeeder.class);

    @Autowired
    CommentRepository commentRepository; 
    EntityManager entityManager;    

    @Override
	public void run(String... args) throws Exception {
		loadCommentData();
	}
    
    /**
     * commentsテーブルへFakerを利用し、モックアップデータ投入するロジック
     * イニシャライズ用の為、対象のテーブルにデータが存在する場合はログ出力して以降の処理は実行しない。
    */
	private void loadCommentData() {
        log.info("start seeder");
        Boolean check_comment_count = checkCommentData();
        if(check_comment_count){
            log.info("already exist comment data");
            return;
        }
        List<CommentEntity> entities = new ArrayList<>();
        Faker faker = new Faker(new Locale("ja_JP"));
        try {
            //fixme: repositoryからランダムメソッドでデータ取得を行う。
            // Query query = entityManager
            // .createNativeQuery("SELECT id FROM users ORDER BY RAND() limit 1");
            // Object result = query.getSingleResult();
            // Integer user_id = result.id;
            Integer post_id = 1;
            for (int i = 0; i < 5; i++) {
                entities.add(new CommentEntity(
                    i,
                    user_id, 
                    post_id,
                    faker.lorem().fixedString(300)
                ));
                System.out.println(faker); 
            }
            commentRepository.saveAll(entities);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ;
    }

    /**
     * 対象テーブルにデータが存在するかチェックする関数
     */
    private boolean checkCommentData() {
        List<CommentEntity> comments = commentRepository.findAll();
        Integer comment_cnt = comments.size();
        if(comment_cnt != 0){
            return true;
        }
        return false;
    }
}