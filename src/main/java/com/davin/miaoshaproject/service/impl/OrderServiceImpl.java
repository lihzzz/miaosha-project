package com.davin.miaoshaproject.service.impl;

import com.davin.miaoshaproject.dao.ItemMapper;
import com.davin.miaoshaproject.dao.ItemStockMapper;
import com.davin.miaoshaproject.dao.OrderInfoMapper;
import com.davin.miaoshaproject.dao.SequenceInfoMapper;
import com.davin.miaoshaproject.error.BusinessError;
import com.davin.miaoshaproject.error.BusinessException;
import com.davin.miaoshaproject.model.Item;
import com.davin.miaoshaproject.model.ItemStock;
import com.davin.miaoshaproject.model.OrderInfo;
import com.davin.miaoshaproject.model.SequenceInfo;
import com.davin.miaoshaproject.service.ItemService;
import com.davin.miaoshaproject.service.OrderService;
import com.davin.miaoshaproject.service.UserService;
import com.davin.miaoshaproject.service.model.ItemModel;
import com.davin.miaoshaproject.service.model.OrderModel;
import com.davin.miaoshaproject.service.model.UserModel;
import com.sun.tools.corba.se.idl.constExpr.Or;
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
    private ItemStockMapper itemStockMapper;
    @Autowired
    private OrderInfoMapper orderInfoMapper;
    @Autowired
    private SequenceInfoMapper sequenceInfoMapper;

    @Autowired
    private ItemService itemService;
    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public OrderModel createOrder(Integer userId, Integer itemId, Integer promoId, Integer amount) throws BusinessException {
//        if(userId == null || itemId == null || amount == null){
//            return null;
//        }
//        ItemStock itemStock = itemStockMapper.selectByItemId(itemId);
//        if(itemStock.getStock() <= 0){
//            return null;
//        }
//        itemStock.setStock(itemStock.getStock()-1);
//        itemStockMapper.updateByItemId(itemStock);
//
//        OrderModel orderModel = new OrderModel();
//        Item item = itemMapper.selectByPrimaryKey(itemId);
//        orderModel.setUserId(userId);
//        orderModel.setItemId(itemId);
//        orderModel.setAmount(amount);
//        orderModel.setItemPrice(item.getPrice());
//        orderModel.setOrderPrice(item.getPrice().multiply(BigDecimal.valueOf(amount)));
//
//        orderModel.setId(this.generatorOrderNo());
//
//        promoId = promoId == null?0:promoId;
//        orderModel.setPromoId(promoId);
//        OrderInfo orderInfo = this.convertFromOrderModel(orderModel);
//        orderInfoMapper.insert(orderInfo);
//
//
//        return orderModel;


        ItemModel itemModel = itemService.getItemById(itemId);

        if(itemModel == null){
            throw new BusinessException(BusinessError.PARAMETER_VALIDATION_ERROR,"shang ping bu cunzai");
        }
        UserModel userModel = userService.getUserById(userId);
        if(userId == null){
            throw new BusinessException(BusinessError.PARAMETER_VALIDATION_ERROR,"yong bu bu cun zai");
        }

        if(amount <= 0 || amount > 99){
            throw new BusinessException(BusinessError.PARAMETER_VALIDATION_ERROR,"shuliangbuzhengque");
        }

        if(promoId != null){
            if(promoId.intValue() != itemModel.getPromoModel().getId()){

            }
        }

        return new OrderModel();

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
