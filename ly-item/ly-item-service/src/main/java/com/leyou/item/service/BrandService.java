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

    /**
     * 分页查询品牌
     * @param page
     * @param rows
     * @param sortBy
     * @param desc
     * @param key
     * @return
     */
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

    /**
     * 新增品牌
     * @param brand
     * @param cids
     */
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

    /**
     * 通过商品分类id查询品牌
     *
     * @param cid 商品分类id
     * @return
     */
    public List<Brand> queryBrandByCid(Long cid) {
        return brandMapper.queryBrandByCid(cid);
    }

    /**
     * 通过品牌id查询品牌
     * @param brandId
     * @return
     */
    public Brand queryByBrandId(Long brandId) {
        return this.brandMapper.selectByPrimaryKey(brandId);
    }

    /**
     * 通过品牌ids查询品牌
     * @param brandIds
     * @return
     */
    public List<Brand> queryByBrandIds(List<Long> brandIds) {
        return this.brandMapper.selectByIdList(brandIds);
    }
}
