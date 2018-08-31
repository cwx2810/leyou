package com.leyou.item.service;

import com.leyou.item.mapper.CategoryMapper;
import com.leyou.item.pojo.Category;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: LieutenantChen
 * @create: 18/8/28 10:21
 **/
@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 通过父节点查询商品分类
     * @param pid
     * @return
     */
    public List<Category> queryCategoryByPid(Long pid) {
        Category t = new Category();
        t.setParentId(pid);
        return this.categoryMapper.select(t);
    }



}
