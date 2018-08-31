package com.leyou.item.controller;

import com.leyou.item.pojo.Category;
import com.leyou.item.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: LieutenantChen
 * @create: 2018-08-28 10:25
 **/
@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 根据父节点查询商品分类
     *
     * @param parentId 商品表父节点id
     * @author cooFive
     * @date 2018/7/20 23:37
     */
    @GetMapping("list")
    public ResponseEntity<List<Category>> queryByParentId(@RequestParam(value = "pid", defaultValue = "0") Long parentId) {
        List<Category> categories = categoryService.queryByParentId(parentId);
        if (categories == null || categories.size() < 1) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(categories);
    }


    /**
     * 根据商品分类id查询商品分类
     *
     * @param ids 分类id
     * @return
     */
    @GetMapping("list/ids")
    public ResponseEntity<List<Category>> queryByCids(@RequestParam(value = "ids", defaultValue = "0") List<Long> ids) {
        List<Category> categories = categoryService.queryByCids(ids);
        if (categories == null || categories.size() < 1) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(categories);
    }

    /**
     * 根据商品分类id查询所有父商品类目
     *
     * @param cid
     * @return
     */
    @GetMapping("/all/level")
    public ResponseEntity<List<Category>> queryAllLevelByCid(@RequestParam(value = "cid") Long cid) {
        List<Category> categories = categoryService.queryAllLevelByCid(cid);
        if (categories == null || categories.size() < 1) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(categories);
    }

}
