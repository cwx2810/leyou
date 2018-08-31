package com.leyou.item.controller;

import com.leyou.common.pojo.PageResult;
import com.leyou.item.pojo.Spu;
import com.leyou.item.pojo.SpuDetail;
import com.leyou.item.service.GoodsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @author: LieutenantChen
 * @create: 2018-08-30 17:18
 **/
@RestController
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    /**
     * 分页查询商品
     *
     * @param page     当前页
     * @param rows     查询的行数
     * @param saleable 是否上架
     * @param key      筛选关键字
     * @return
     */
    @GetMapping("/spu/page")
    public ResponseEntity<PageResult<Spu>> querySpuByPage(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows,
            @RequestParam(value = "saleable", required = false) Boolean saleable,
            @RequestParam(value = "key", required = false) String key
    ) {
        PageResult<Spu> pageResult = this.goodsService.querySpuByPage(page, rows, saleable, key);
        if (pageResult == null || CollectionUtils.isEmpty(pageResult.getItems())) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(pageResult);
    }

    /**
     * 新增商品
     *
     * @param spu
     * @return
     */
    @PostMapping("goods")
    public ResponseEntity<Void> saveGoods(@RequestBody Spu spu) {
        // 做数据的校验
        if (!StringUtils.isEmpty(spu)) {
            Boolean result = this.goodsService.saveGoods(spu);
            if (result) {
                return new ResponseEntity<>(HttpStatus.CREATED);
            }else {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        }
        //this.goodsService.
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}