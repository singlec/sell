package com.imooc.VO;

import lombok.Data;

/**
 * http返回请求的最外层
 * Create By 一条狗
 * 2018/4/15 18:29
 */
@Data
public class ResultVO<T> {

    /** 错误码 */
    private Integer code;

    /** 提示信息 */
    private String msg;

    /** 内容 */
    private T data;
}
