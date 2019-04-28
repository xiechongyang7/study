package com.seesea.study.common;

import com.seesea.study.common.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/12/13 14:34
 * @Author xie
 */
public abstract class BaseController {

    public Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object exp(Exception ex) {
        Result result = new Result();
        logger.info("好好{}", this.toString());
        if (ex instanceof NullPointerException) {
//            logger.error("{}传输报文参数空指针异常..", new Object[] { requestURI }, ex);
            result.setCode("ddd");
            result.setMsg("ddd");
        } else if (ex instanceof NumberFormatException) {
//            logger.error("{}传输报文参数异常..", new Object[] { requestURI }, ex);
            result.setCode("ccc");
            result.setMsg("ccc");
        } else if (ex instanceof BaseException) {
//            logger.error("{}传输报文参数异常..", new Object[] { requestURI }, ex);
            BaseException e = (BaseException) ex;
            result.setCode(e.errCode);
            result.setMsg(e.getMessage());
        } else {
//            logger.error("{}应用层异常..", new Object[] { requestURI }, ex);
            result.setCode("lllll");
            result.setMsg(ex.getMessage());
        }
        return result;
    }
}
