package com.sjp.ddshop.dao;

import com.sjp.ddshop.pojo.po.TbItemCat;
import com.sjp.ddshop.pojo.po.TbItemCatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbItemCatMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_cat
     *
     * @mbggenerated Sat Nov 04 10:48:37 CST 2017
     */
    int countByExample(TbItemCatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_cat
     *
     * @mbggenerated Sat Nov 04 10:48:37 CST 2017
     */
    int deleteByExample(TbItemCatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_cat
     *
     * @mbggenerated Sat Nov 04 10:48:37 CST 2017
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_cat
     *
     * @mbggenerated Sat Nov 04 10:48:37 CST 2017
     */
    int insert(TbItemCat record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_cat
     *
     * @mbggenerated Sat Nov 04 10:48:37 CST 2017
     */
    int insertSelective(TbItemCat record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_cat
     *
     * @mbggenerated Sat Nov 04 10:48:37 CST 2017
     */
    List<TbItemCat> selectByExample(TbItemCatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_cat
     *
     * @mbggenerated Sat Nov 04 10:48:37 CST 2017
     */
    TbItemCat selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_cat
     *
     * @mbggenerated Sat Nov 04 10:48:37 CST 2017
     */
    int updateByExampleSelective(@Param("record") TbItemCat record, @Param("example") TbItemCatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_cat
     *
     * @mbggenerated Sat Nov 04 10:48:37 CST 2017
     */
    int updateByExample(@Param("record") TbItemCat record, @Param("example") TbItemCatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_cat
     *
     * @mbggenerated Sat Nov 04 10:48:37 CST 2017
     */
    int updateByPrimaryKeySelective(TbItemCat record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_cat
     *
     * @mbggenerated Sat Nov 04 10:48:37 CST 2017
     */
    int updateByPrimaryKey(TbItemCat record);
}