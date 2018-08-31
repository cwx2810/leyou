package com.leyou.item.mapper;

import com.leyou.item.pojo.Sku;
import tk.mybatis.mapper.additional.idlist.DeleteByIdListMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author: LieutenantChen
 * @create: 2018-08-30 17:45
 **/
public interface SkuMapper extends Mapper<Sku>, DeleteByIdListMapper<Sku, Long> {
}
