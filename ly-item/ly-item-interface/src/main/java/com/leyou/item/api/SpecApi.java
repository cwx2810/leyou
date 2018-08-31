package com.leyou.item.api;
import com.leyou.item.pojo.SpecGroup;
import com.leyou.item.pojo.SpecParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
/**
 * @author: LieutenantChen
 * @create: 2018-08-31 20:21
 **/
@RequestMapping("spec")
public interface SpecApi {
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
    List<SpecParam> querySpecParam(
            @RequestParam(value = "gid", required = false) Long group_id,
            @RequestParam(value = "cid", required = false) Long cid,
            @RequestParam(value = "generic", required = false) Boolean generic,
            @RequestParam(value = "searching", required = false) Boolean searching
    );

    /**
     * 根据分类id查询规格组以及规格组内参数
     *
     * @param cid3 商品分类id
     * @return
     */
    @GetMapping("groups/{cid}")
    List<SpecGroup> querySpecGroupByCid(@PathVariable("cid") Long cid3);
}
