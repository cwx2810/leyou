package com.leyou.item.service;

import com.leyou.item.mapper.CategoryMapper;
import com.leyou.item.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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
     * @param parentId
     * @return
     */
    public List<Category> queryByParentId(Long parentId) {
        Category category = new Category();
        category.setParentId(parentId);
        return categoryMapper.select(category);
    }

    /**
     * 通过商品分类id查询商品分类
     * @param ids
     * @return
     */
    public List<Category> queryByCids(List<Long> ids) {
        return categoryMapper.selectByIdList(ids);
    }

    /**
     * 根据商品分类id查询所有父商品类目
     * @param cid
     * @return
     */
    public List<Category> queryAllLevelByCid(Long cid) {
        Category cid3 = this.categoryMapper.selectByPrimaryKey(cid);
        Category cid2 = this.categoryMapper.selectByPrimaryKey(cid3.getParentId());
        Category cid1 = this.categoryMapper.selectByPrimaryKey(cid2.getParentId());
        return Arrays.asList(cid1, cid2, cid3);
    }
}
