package com.imooc.enums;

import lombok.Getter;

@Getter
public enum ProductStatusEnum {
    UP(0, "在架"),
    Down(1,"下架")
    ;
    private String message;
    private Integer code;

    ProductStatusEnum(Integer code,String message) {
        this.code = code;
        this.message = message;
    }
}
