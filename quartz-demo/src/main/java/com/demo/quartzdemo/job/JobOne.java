package com.demo.quartzdemo.job;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.UUID;

/**
 * @description
 * @author: xcy
 * @createTime: 2020/7/24 14:58
 */
@DisallowConcurrentExecution
public class JobOne extends QuartzJobBean {
    @Value("${spring.server.port}")
    private String port;

    Logger logger = LoggerFactory.getLogger(JobOne.class);
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        // 获取参数
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        // 业务逻辑 ...
        logger.info("------springbootquartzonejob执行"+jobDataMap.get("name").toString()+"###############"+jobExecutionContext.getTrigger());

        logger.info("-------------port---------"+port+"-------------");

        try {
            String str  = UUID.randomUUID().toString().replace("-","");
            logger.info("-------------logTag--start---------"+ str +"-------------");
            Thread.sleep(10000);
            logger.info("-------------logTag--end-----------"+ str +"-------------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try{

        }catch (Exception e){
            JobExecutionException e2 = new JobExecutionException(e);
            // 这个工作将立即重新开始
            e2.setRefireImmediately(true);
//            // 自动取消与此作业关联的所有触发器计划
//            e2.setUnscheduleAllTriggers(true);

            throw e2;



        }
    }
}
