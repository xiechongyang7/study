package com.example.reqdemo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author xiechongyang
 * @description
 * @createTime 2019/2/13 上午 11:04
 * @since JDK1.8
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {
    Logger logger = LoggerFactory.getLogger(TestController.class);
    ObjectMapper mapper = new ObjectMapper();

    @RequestMapping(value = "/json", method = RequestMethod.POST)
    @ResponseBody
    public Object json(@RequestBody TestModel testModel) throws JsonProcessingException {
        logger.info("接受参数" + mapper.writeValueAsString(testModel));
        return mapper.writeValueAsString(testModel);
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    @ResponseBody
    public Object form(TestModel testModel) throws JsonProcessingException {
        logger.info("接受参数" + mapper.writeValueAsString(testModel));

        for (String str : testModel.getMyList()) {
            logger.info("哈哈：{}", str);
        }
        for (String str : testModel.getMyStrArry()) {
            logger.info("哈哈：{}", str);
        }
        return mapper.writeValueAsString(testModel);
    }


    @RequestMapping(value = "/formArray", method = RequestMethod.POST)
    @ResponseBody
    public Object formAndFile(TestArray array) throws JsonProcessingException {
        logger.info("接受参数" + mapper.writeValueAsString(array));
        return mapper.writeValueAsString(array);
    }

    @RequestMapping(value = "/jsonAndFile", method = RequestMethod.POST)
    @ResponseBody
    public Object jsonAndFile(TestModelVo vo) throws IOException {

//        logger.info("接受参数"+mapper.writeValueAsString(vo));
        MultipartFile file = vo.getFile();
        file.transferTo(new File("G:\\1.jpg"));
        return file.getName() + "  " + file.getOriginalFilename() + "  " + file.getSize();

    }

    @RequestMapping(value = "/page/{a}/{b}", method = RequestMethod.POST)
    @ResponseBody
    public Object jsonAndFile(@PathVariable String a, @PathVariable String b) {
        return null;
    }
}
