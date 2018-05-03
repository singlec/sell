package com.imooc.utils;

import java.util.Random;

/**
 * Create By 一条狗
 * 2018/4/21 13:25
 */
public class KeyUtil {

    /** 生成唯一主键的方法 */
    public static synchronized String generateUniqueKey() {
        int num = new Random().nextInt(900000) + 100000;
        return System.currentTimeMillis()+String .valueOf(num);
    }
}
