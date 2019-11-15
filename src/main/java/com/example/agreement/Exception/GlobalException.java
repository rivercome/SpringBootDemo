package com.example.agreement.Exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class GlobalException {
    @ExceptionHandler({ServiceException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String,Object> handlerServiceException(ServiceException exception){
        log.error("发生异常");
        Map<String,Object> result = new HashMap();
        result.put("code","1000");
        System.out.println(exception.getId() + "：异常错误信息！");
        return result;
    }

    @ExceptionHandler({ErrorParamsException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String,Object> handlerServiceException(ErrorParamsException exception){
        log.error("发生异常");
        Map<String,Object> result = new HashMap();
        log.error(String.valueOf(exception));
        result.put("code","1000");
        return result;
    }

}
