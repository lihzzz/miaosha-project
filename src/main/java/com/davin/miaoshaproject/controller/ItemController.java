package com.davin.miaoshaproject.controller;

import com.davin.miaoshaproject.controller.viewobject.ItemVo;
import com.davin.miaoshaproject.response.CommonReturnType;
import com.davin.miaoshaproject.service.ItemService;
import com.davin.miaoshaproject.service.model.ItemModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/item")
@CrossOrigin(origins = {"*"}, allowCredentials = "true")
public class ItemController extends BaseController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    @ResponseBody
    public CommonReturnType getItem(@RequestParam(name = "id")Integer id){
        ItemModel itemModel = itemService.getItemById(id);
        ItemVo itemVo = convertItemVoFromItemModel(itemModel);
        return CommonReturnType.create(itemVo);
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public CommonReturnType listItem(){
        List<ItemModel> itemModels = itemService.listItem();
        List<ItemVo> itemVos = itemModels.stream().map(itemModel -> {
            ItemVo itemVo = convertItemVoFromItemModel(itemModel);
            return itemVo;
        }).collect(Collectors.toList());
        return CommonReturnType.create(itemVos);
    }



    private ItemVo convertItemVoFromItemModel(ItemModel itemModel){
        if(itemModel == null){
            return null;
        }
        ItemVo itemVo = new ItemVo();
        BeanUtils.copyProperties(itemModel,itemVo);
        return itemVo;
    }


}
