package com.davin.miaoshaproject.service.impl;

import com.davin.miaoshaproject.dao.ItemMapper;
import com.davin.miaoshaproject.dao.OrderInfoMapper;
import com.davin.miaoshaproject.dao.SequenceInfoMapper;
import com.davin.miaoshaproject.error.BusinessException;
import com.davin.miaoshaproject.model.Item;
import com.davin.miaoshaproject.model.OrderInfo;
import com.davin.miaoshaproject.model.SequenceInfo;
import com.davin.miaoshaproject.service.OrderService;
import com.davin.miaoshaproject.service.model.ItemModel;
import com.davin.miaoshaproject.service.model.OrderModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private OrderInfoMapper orderInfoMapper;
    @Autowired
    private SequenceInfoMapper sequenceInfoMapper;
    @Override
    public OrderModel createOrder(Integer userId, Integer itemId, Integer promoId, Integer amount) throws BusinessException {
        if(userId == null || itemId == null || amount == null){
            return null;
        }
        OrderModel orderModel = new OrderModel();
        Item item = itemMapper.selectByPrimaryKey(itemId);
        orderModel.setUser_id(userId);
        orderModel.setItem_id(itemId);
        orderModel.setPromp_id(promoId);
        orderModel.setAmount(amount);
        orderModel.setItem_price(item.getPrice());
        orderModel.setOrder_price(item.getPrice().multiply(BigDecimal.valueOf(amount)));

        orderModel.setId(this.generatorOrderNo());

        promoId = promoId == null?0:promoId;
        orderModel.setPromp_id(promoId);
        return orderModel;
    }

    @Transactional
    @Override
    public String generatorOrderNo() {
        StringBuilder stringBuilder = new StringBuilder();
        LocalDateTime now = LocalDateTime.now();
        String nowDate = now.format(DateTimeFormatter.ISO_DATE).replace("-","");
        stringBuilder.append(nowDate);

        int sequence = 0;
        SequenceInfo sequenceInfo = sequenceInfoMapper.selectByPrimaryKey("order_info");
        sequence = sequenceInfo.getCurrentValue();
        sequenceInfo.setCurrentValue(sequenceInfo.getCurrentValue() + sequenceInfo.getStep());

        sequenceInfoMapper.updateByPrimaryKeySelective(sequenceInfo);

        String sequenceStr = String.valueOf(sequence);
        for (int i = 0; i < 6 - sequenceStr.length(); i++) {
           stringBuilder.append(0);
        }

        stringBuilder.append(sequenceStr);

        stringBuilder.append("00");
        return stringBuilder.toString();

    }

    @Override
    public OrderInfo convertFromOrderModel(OrderModel orderModel) {
        if(orderModel == null){
            return null;
        }
        OrderInfo orderInfo = new OrderInfo();
        BeanUtils.copyProperties(orderModel,orderInfo);
        return orderInfo;
    }
}
