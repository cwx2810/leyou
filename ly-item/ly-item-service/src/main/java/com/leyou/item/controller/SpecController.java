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
     * 根据分类id查询规格组以及规格组内参数
     *
     * @param cid3 商品分类id
     * @return
     */
    @GetMapping("groups/{cid}")
    public ResponseEntity<List<SpecGroup>> querySpecGroupByCid(@PathVariable("cid") Long cid3) {
        List<SpecGroup> groups = specService.querySpecGroupByCid(cid3);

        if (groups == null || groups.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(groups);
    }
    /**
     * 查询规格参数
     *
     * @param group_id
     * @param cid
     * @param generic
     * @param searching
     * @return
     */
    @GetMapping("params")
    public ResponseEntity<List<SpecParam>> querySpecParam(
            @RequestParam(value = "gid", required = false) Long group_id,
            @RequestParam(value = "cid", required = false) Long cid,
            @RequestParam(value = "generic", required = false) Boolean generic,
            @RequestParam(value = "searching", required = false) Boolean searching
    ) {
        List<SpecParam> params = specService.querySpecParam(group_id, cid, generic, searching);

        if (params == null || params.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(params);
    }
}
