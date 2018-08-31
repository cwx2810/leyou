package com.leyou.item.api;

import com.leyou.item.pojo.Brand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author: LieutenantChen
 * @create: 2018-08-31 20:12
 **/
@RequestMapping("brand")
public interface BrandApi {
    /**
     * 通过brandId查询品牌
     *
     * @param brandId
     * @return
     */
    @GetMapping("brandId")
    Brand queryByBrandId(@RequestParam(value = "brandId", defaultValue = "0") Long brandId);

    /**
     * 通过brandIds查询品牌
     *
     * @param brandIds
     * @return
     */
    @GetMapping("brandIds")
    List<Brand> queryByBrandIds(@RequestParam(value = "brandIds")List<Long> brandIds);
}
