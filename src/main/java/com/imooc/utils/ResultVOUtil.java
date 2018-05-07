package com.imooc.utils;

import com.imooc.VO.ResultVO;

/**
 * Create By 一条狗
 * 2018/4/24 21:25
 */
public class ResultVOUtil {

    public static ResultVO success() {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

    public static ResultVO success(Object data) {
        ResultVO resultVO = success();
        resultVO.setData(data);
        return resultVO;
    }

    public static ResultVO error(Integer code,String message) {
        ResultVO<Object> resultVO= new ResultVO<>();
        resultVO.setCode(code);
        resultVO.setMsg(message);
        return resultVO;
    }
}
