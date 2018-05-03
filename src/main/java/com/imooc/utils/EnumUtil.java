package com.imooc.utils;

import com.imooc.enums.CodeEnum;

/**
 * Create By 一条狗
 * 2018/5/2 22:57
 */
public class EnumUtil<T> {
    public static <T extends CodeEnum>T getEnumByCode(Integer code, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if (each.getCode().equals(code)) {
                return each;
            }
        }
        return null;
    }
}
