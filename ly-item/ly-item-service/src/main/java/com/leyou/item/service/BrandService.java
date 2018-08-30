package com.leyou.item.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leyou.common.pojo.PageResult;
import com.leyou.item.mapper.BrandMapper;
import com.leyou.item.pojo.Brand;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author: LieutenantChen
 * @create: 2018-08-28 18:01
 **/
@Service
public class BrandService {

    @Autowired
    private BrandMapper brandMapper;

    public PageResult<Brand> queryBrandByPage(Integer page, Integer rows, String sortBy, Boolean desc, String key) {
        // 分页
        PageHelper.startPage(page, rows);
        // 通用mapper创建一个查询对象
        Example example = new Example(Brand.class);
        // 排序
        if (StringUtils.isNotBlank(sortBy)) {
            example.setOrderByClause(sortBy + (desc ? " DESC" : " ASC"));
        }
        // 查询
        if (StringUtils.isNotBlank(key)) {
            example.createCriteria().andLike("name", "%" + key + "%")
                    .orEqualTo("letter", key);
        }
        // 通用mapper的高级查询
        List<Brand> list = this.brandMapper.selectByExample(example);
        // 创建pageInfo
        PageInfo<Brand> info = new PageInfo<>(list);
        // 返回结果
        return new PageResult<>(info.getTotal(), info.getList());
    }

    @Transactional
    public void saveBrand(Brand brand, List<Long> cids) {
        // 新增品牌信息
        this.brandMapper.insertSelective(brand);
        // 新增品牌和分类中间表
        for (Long cid : cids) {
            // 用我们自定义的mapper方法实现中间表的新增
            this.brandMapper.insertCategoryBrand(cid, brand.getId());
        }
    }

    @Transactional
    public void updateBrand(List<Long> categories, Brand brand) {
        //修改品牌
        brandMapper.updateByPrimaryKeySelective(brand);
        //维护中间表
        for (Long categoryId : categories) {
            brandMapper.updateCategoryBrand(categoryId, brand.getId());
        }
    }

    public void deleteBrand(Long bid) {
        //删除品牌表
        brandMapper.deleteByPrimaryKey(bid);
        //维护中间表
        brandMapper.deleteCategoryBrandByBid(bid);
    }
}
