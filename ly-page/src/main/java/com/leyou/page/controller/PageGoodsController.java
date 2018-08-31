package com.leyou.page.controller;

import com.leyou.page.service.FileService;
import com.leyou.page.service.PageGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Map;


/**
 * @author: LieutenantChen
 * @create: 2018-08-31 21:30
 **/
@Controller
@RequestMapping("item")
public class PageGoodsController {

    @Autowired
    private PageGoodsService pageGoodsService;

    @Autowired
    private FileService fileService;

    /**
     * 商品详情页面查询
     *
     * @param spuId
     * @return
     */
    @RequestMapping("{id}.html")
    public String toItemPage(@PathVariable("id") Long spuId, Model model) {
        // 商品详情页面需要多个数据,封装成Map<String,Object>
        // service封装数据
        Map<String, Object> map = this.pageGoodsService.addGoodsToMap(spuId);
        model.addAllAttributes(map);
        // 判断是否需要生成新的静态页面
        if(!this.fileService.existsHtml(spuId)){
            this.fileService.syncCreateHtml(spuId);
        }
        return "item";
    }
}
