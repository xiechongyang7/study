package com.seesea.study;

import com.seesea.rely.handle.ScanHandle;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
@MapperScan(basePackages = "com.seesea.study.mapper")
public class StudyApplication implements CommandLineRunner {

    public static void main(String[] args) {
//        String[] strings = {"com.seesea.study.mapper","com.seesea.study.model"};
//        new ScanHandle(strings);
        SpringApplication.run(StudyApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        String[] strings = {"com.seesea.study.mapper","com.seesea.study.model"};
        ScanHandle.scan(strings);
    }
}
