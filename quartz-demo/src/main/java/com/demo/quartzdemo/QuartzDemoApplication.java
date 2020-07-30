package com.demo.quartzdemo;

import com.demo.quartzdemo.job.JobOne;
import com.demo.quartzdemo.service.QuartzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;

@SpringBootApplication
public class QuartzDemoApplication implements CommandLineRunner {

    @Autowired
    private QuartzService quartzService;

    public static void main(String[] args) {
        SpringApplication.run(QuartzDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        HashMap<String,Object> map = new HashMap<>();
        map.put("name",1);

        Class.forName("JobOne");
        quartzService.deleteJob("job", "test");
        quartzService.addJob(JobOne.class, "job", "test", "0/5 * * * * ? ", map);

//        map.put("name",2);
        quartzService.deleteJob("job2", "test");
//        quartzService.addJob(JobOne.class, "job2", "test", "10 * * * * ?", map);

//        map.put("name",3);
        quartzService.deleteJob("job3", "test2");
//        quartzService.addJob(JobOne.class, "job3", "test2", "15 * * * * ?", map);
    }
}
