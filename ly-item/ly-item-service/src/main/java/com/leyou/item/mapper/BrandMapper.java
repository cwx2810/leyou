package com.leyou.item.mapper;

import com.leyou.item.pojo.Brand;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.additional.idlist.SelectByIdListMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author: LieutenantChen
 * @create: 2018-08-28 18:00
 **/
public interface BrandMapper extends Mapper<Brand>, SelectByIdListMapper<Brand,Long> {
    /**
     * 插入商品分类和品牌中间表数据
     * @param cid 商品分类id
     * @param bid 品牌id
     * @return
     */
    @Insert("INSERT INTO tb_category_brand (category_id, brand_id) VALUES (#{cid},#{bid})")
    int insertCategoryBrand(@Param("cid") Long cid, @Param("bid") Long bid);

    /**
     * 通过商品分类id查询品牌
     * @param cid
     * @return
     */
    @Select("SELECT * FROM tb_brand b\n" +
            "LEFT JOIN tb_category_brand cb ON b.id = cb.brand_id\n" +
            "WHERE cb.category_id = #{cid}")
    List<Brand> queryBrandByCid(@Param("cid") Long cid);
}
