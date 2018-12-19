package com.seesea.study.service;

import com.seesea.rely.thread.Runable;
import com.seesea.rely.thread.ThreadPoolManager;
import com.seesea.study.common.BaseException;
import com.seesea.study.mapper.UserMapper;
import com.seesea.study.model.OneList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

    public OneList test(int num) throws BaseException {
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
        List list= userMapper.selectAll();
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

        return oneList;
    }
}
