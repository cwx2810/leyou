package com.leyou.item.mapper;

import com.leyou.item.pojo.Stock;
import tk.mybatis.mapper.additional.idlist.DeleteByIdListMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author: LieutenantChen
 * @create: 2018-08-30 17:47
 **/
public interface StockMapper extends Mapper<Stock>, DeleteByIdListMapper<Stock, Long> {
}
