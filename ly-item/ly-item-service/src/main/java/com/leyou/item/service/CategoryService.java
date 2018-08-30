package com.leyou.item.service;

import com.leyou.item.mapper.CategoryMapper;
import com.leyou.item.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: LieutenantChen
 * @create: 18/8/28 10:21
 **/
@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> queryCategoryByPid(Long pid) {
        Category t = new Category();
        t.setParentId(pid);
        return this.categoryMapper.select(t);
    }

    public List<Category> queryByBrandId(Long bid) {
        return this.categoryMapper.queryByBrandId(bid);
    }
}
