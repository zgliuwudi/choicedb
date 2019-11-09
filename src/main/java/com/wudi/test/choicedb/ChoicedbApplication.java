package com.wudi.test.choicedb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wudi.test.choicedb.mapper")
public class ChoicedbApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChoicedbApplication.class, args);
    }

}
