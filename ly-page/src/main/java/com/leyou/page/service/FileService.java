package com.leyou.page.service;

import com.leyou.page.service.FileService;
import com.leyou.page.service.PageGoodsService;
import com.leyou.common.utils.ThreadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import java.io.File;
import java.io.PrintWriter;
/**
 * @author: LieutenantChen
 * @create: 2018-08-31 23:26
 **/
@Service
public class FileService {
    @Autowired
    private PageGoodsService pageGoodsService;
    @Autowired
    private TemplateEngine templateEngine;
    @Value("${ly.thymeleaf.destPath}")
    private String destPath;
    /**
     * 生成静态化页面
     *
     * @param spuId 商品集id
     */
    public void createHtml(Long spuId) throws Exception {
        // 创建上下文
        Context context = new Context();
        // 把数据加入上下文,map结构
        context.setVariables(this.pageGoodsService.addGoodsToMap(spuId));
        // 创建输出流，关联到一个临时文件
        File tmp = new File(spuId + ".html");
        // 创建目标文件
        File dest = createPath(spuId);
        // 创建备份原页面文件
        File bak = new File(spuId + "_bak.html");
        try (PrintWriter writer = new PrintWriter(tmp, "utf-8")) {
            // 利用thymeleaf模板引擎生成 静态页面
            templateEngine.process("item", context, writer);
            // 如果目标文件存在，先备份
            if (dest.exists()) {
                dest.renameTo(bak);
            }
            // 将新页面覆盖旧页面
            FileCopyUtils.copy(tmp, dest);
            // 成功后将备份页面删除
            bak.delete();
        } catch (Exception e) {
            e.printStackTrace();
            // 有异常，失败，将备份页面恢复
            bak.renameTo(dest);
            // 重新抛出异常,声明页面生成失败
            throw new RuntimeException("页面生成失败");
        } finally {
            // finally, 删除临时页面
            if (tmp != null) {
                tmp.delete();
            }
        }
    }
    /**
     * 判断静态页面是否已经生成
     *
     * @param spuId
     * @return
     */
    public boolean existsHtml(Long spuId) {
        return this.createPath(spuId).exists();
    }
    /**
     * 异步生成静态页面
     *
     * @param spuId
     */
    public void syncCreateHtml(Long spuId) {
        ThreadUtils.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    createHtml(spuId);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    /**
     * 创建详情页路径
     *
     * @param id
     * @return
     */
    private File createPath(Long id) {
        if (id == null) {
            return null;
        }
        File dest = new File(this.destPath);
        if (!dest.exists()) {
            dest.mkdirs();
        }
        return new File(dest, id + ".html");
    }
}
