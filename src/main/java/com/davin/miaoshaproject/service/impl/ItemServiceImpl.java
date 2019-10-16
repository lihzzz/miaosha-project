package com.davin.miaoshaproject.service.impl;

import com.davin.miaoshaproject.dao.ItemMapper;
import com.davin.miaoshaproject.dao.ItemStockMapper;
import com.davin.miaoshaproject.error.BusinessException;
import com.davin.miaoshaproject.model.Item;
import com.davin.miaoshaproject.model.ItemStock;
import com.davin.miaoshaproject.service.ItemService;
import com.davin.miaoshaproject.service.model.ItemModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private ItemStockMapper itemStockMapper;
    @Override
    public ItemModel createItem(ItemModel itemModel) throws BusinessException {
        if(itemModel == null){
            return null;
        }
        Item item = convertItemFromItemModel(itemModel);
        itemMapper.insertSelective(item);

        ItemStock itemStock = convertItemStockFromItemModel(itemModel);
        itemStock.setItemId(item.getId());
        itemStockMapper.insertSelective(itemStock);
        return this.getItemById(item.getId());
    }

    private Item convertItemFromItemModel(ItemModel model){
        if(model == null){
            return null;
        }
        Item item = new Item();
        BeanUtils.copyProperties(model,item);
        return item;
    }

    private ItemStock convertItemStockFromItemModel(ItemModel model){
        if(model == null){
            return null;
        }
        ItemStock itemStock = new ItemStock();
        BeanUtils.copyProperties(model,itemStock);
        return itemStock;
    }

    private ItemModel converModelFromDataObject(Item item,ItemStock itemStock){
        if(item == null || itemStock == null){
            return null;
        }
        ItemModel itemModel = new ItemModel();
        BeanUtils.copyProperties(item,itemModel);
        itemModel.setStock(itemStock.getStock());
        return itemModel;
    }

    @Override
    public List<ItemModel> listItem() {
        List<Item> itemList = itemMapper.listItem();
        List<ItemModel> itemModelList = itemList.stream().map(
                item -> {
                    ItemStock itemStock = itemStockMapper.selectByItemId(item.getId());
                    ItemModel itemModel = converModelFromDataObject(item,itemStock);
                    return itemModel;
                }
        ).collect(Collectors.toList());
        return itemModelList;
    }

    @Override
    public ItemModel getItemById(Integer id) {
        Item item = itemMapper.selectById(id);

        if(item == null){
            return null;
        }
        ItemModel itemModel = new ItemModel();
        BeanUtils.copyProperties(itemModel,item);

        ItemStock itemStock = itemStockMapper.selectByItemId(item.getId());
        itemModel.setStock(itemStock.getStock());
        return itemModel;

    }

    @Override
    public boolean decreaseStock(Integer itemId, Integer amount) {
        return false;
    }

    @Override
    public void increaseSales(Integer itemId, Integer amount) throws BusinessException {

    }
}
