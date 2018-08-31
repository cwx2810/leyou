package com.leyou.item.controller;
import com.leyou.item.pojo.SpecGroup;
import com.leyou.item.pojo.SpecParam;
import com.leyou.item.service.SpecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author: LieutenantChen
 * @create: 2018-08-31 18:03
 **/
@RestController
@RequestMapping("spec")
public class SpecController {
    @Autowired
    private SpecService specService;
    /**
     * 通过商品分类id查询规格组
     *
     * @param cid
     * @return
     */
    @GetMapping("groups/{cid}")
    public ResponseEntity<List<SpecGroup>> querySpecGroupByCid(@PathVariable("cid") Long cid) {
        List<SpecGroup> groups = specService.querySpecGroupByCid(cid);
        if (groups == null || groups.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(groups);
    }
    /**
     * 通过规格组id查询规格参数
     *
     * @param group_id
     * @param cid
     * @return
     */
    @GetMapping("params")
    public ResponseEntity<List<SpecParam>> querySpecParamByGid(
            @RequestParam(value = "gid", required = false) Long group_id,
            @RequestParam(value = "cid", required = false) Long cid
    ) {
        List<SpecParam> params = specService.querySpecParamByGid(group_id, cid);
        if (params == null || params.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(params);
    }
}
