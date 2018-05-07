package com.imooc.handler;

import com.imooc.VO.ResultVO;
import com.imooc.exception.SellException;
import com.imooc.utils.ResultVOUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * sellException统一处理
 */
@ControllerAdvice
public class SellExceptionHandler {

    @ExceptionHandler(SellException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public ResultVO handler(SellException e) {
        return ResultVOUtil.error(e.getCode(), e.getMessage());
    }
}
