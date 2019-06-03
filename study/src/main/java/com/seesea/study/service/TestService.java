package com.seesea.study.service;

import com.seesea.rely.thread.Runable;
import com.seesea.rely.thread.ThreadPoolManager;
import com.seesea.study.common.BaseException;
import com.seesea.study.mapper.UserMapper;
import com.seesea.study.model.OneList;
import com.seesea.study.mongodb.Mian;
import com.seesea.study.mongodb.TestBig;
import com.seesea.study.util.util;
import com.sun.corba.se.spi.orbutil.threadpool.ThreadPoolManager;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/12/7 14:34
 * @Author xie
 */
@Service
public class TestService {

    static Logger logger1 = LoggerFactory.getLogger(TestService.class);
    @Autowired
    private UserMapper userMapper;
    @Autowired
    Mian mian;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public OneList test(int num) throws BaseException, IOException {
//        System.out.println("hhhhh");
//        try{
//            if(num == 1){
//                throw new BaseException(ErrorEnum.ERR_0000);
//            }
//        }catch (BaseException e){
//            throw new BaseException(e);
//        }
        logger1.info("進入綫程前");
//        int i = 1/0;
        List list = userMapper.selectAll();
        OneList oneList = new OneList();
        oneList.setList(list);


//        ThreadPoolManager.addThread(new Runnable() {
//            String reqNo = MDC.get("reqNo");//获取reqNo
//            @Override
//            public void run() {
//                MDC.put("reqNo",reqNo);//添加父线程reqNo
//                logger1.info("進入线程后{}");
//                MDC.remove("reqNo");;//完成
//            }
//        });
        ThreadPoolManager.addThread(new Runable() {
            @Override
            public void constRun() {
                logger1.info("進入线程后{}");
            }
        });


        File file = new File("G:\\上线相关\\e签宝\\模板\\借款协议.pdf");

        TestBig testBig = new TestBig();
        testBig.setId(1);

        testBig.setData(util.byte2Base64StringFun(FileUtils.readFileToByteArray(file)));

        mian.go(testBig);

//        TestBig testBig1 = mian.lets("1");


        Query query = new Query();
        Criteria criteria = Criteria.where("_id").is(1);
        query.addCriteria(criteria);
//        log.info("[Mongo Dao ]queryById:" + query);
        TestBig testBig1 = mongoTemplate.findOne(query, TestBig.class);

//        FileUtils.writeByteArrayToFile(new File("G:\\上线相关\\e签宝\\模板\\借款协议1.pdf"),util.base64String2ByteFun(testBig1.getData()));


        String context = "hello " + new Date();
        System.out.println("Sender : " + context);
        rabbitTemplate.convertAndSend("hello", context);
//        rabbitTemplate.convertAndSend();


        return oneList;
    }
}
