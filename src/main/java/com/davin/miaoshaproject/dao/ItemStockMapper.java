package com.davin.miaoshaproject.dao;

import com.davin.miaoshaproject.model.ItemStock;
import com.davin.miaoshaproject.model.ItemStockExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemStockMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_stock
     *
     * @mbg.generated Wed Oct 16 14:49:47 CST 2019
     */
    long countByExample(ItemStockExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_stock
     *
     * @mbg.generated Wed Oct 16 14:49:47 CST 2019
     */
    int deleteByExample(ItemStockExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_stock
     *
     * @mbg.generated Wed Oct 16 14:49:47 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_stock
     *
     * @mbg.generated Wed Oct 16 14:49:47 CST 2019
     */
    int insert(ItemStock record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_stock
     *
     * @mbg.generated Wed Oct 16 14:49:47 CST 2019
     */
    int insertSelective(ItemStock record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_stock
     *
     * @mbg.generated Wed Oct 16 14:49:47 CST 2019
     */
    List<ItemStock> selectByExample(ItemStockExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_stock
     *
     * @mbg.generated Wed Oct 16 14:49:47 CST 2019
     */
    ItemStock selectByPrimaryKey(Integer id);
    ItemStock selectByItemId (Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_stock
     *
     * @mbg.generated Wed Oct 16 14:49:47 CST 2019
     */
    int updateByExampleSelective(@Param("record") ItemStock record, @Param("example") ItemStockExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_stock
     *
     * @mbg.generated Wed Oct 16 14:49:47 CST 2019
     */
    int updateByExample(@Param("record") ItemStock record, @Param("example") ItemStockExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_stock
     *
     * @mbg.generated Wed Oct 16 14:49:47 CST 2019
     */
    int updateByPrimaryKeySelective(ItemStock record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_stock
     *
     * @mbg.generated Wed Oct 16 14:49:47 CST 2019
     */
    int updateByPrimaryKey(ItemStock record);


    int updateByItemId(ItemStock record);
}