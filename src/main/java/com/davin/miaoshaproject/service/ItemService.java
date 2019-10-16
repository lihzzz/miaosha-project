package com.davin.miaoshaproject.service;

import com.davin.miaoshaproject.error.BusinessException;
import com.davin.miaoshaproject.service.model.ItemModel;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ItemService {
    ItemModel createItem(ItemModel itemModel) throws BusinessException;

    List<ItemModel> listItem();

    ItemModel getItemById(Integer id);

    boolean decreaseStock(Integer itemId,Integer amount);

    void increaseSales(Integer itemId,Integer amount) throws BusinessException;
}
