package com.imooc.service.impl;

import com.imooc.dto.OrderDTO;
import com.imooc.service.PushMessage;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PushMessageImpl implements PushMessage {

    @Autowired
    private WxMpService wxMpService;

    @Override
    public void orderStatus(OrderDTO orderDTO) {

    }
}
