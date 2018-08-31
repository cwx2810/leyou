package com.leyou.page.client;

import com.leyou.item.api.CategoryApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author: LieutenantChen
 * @create: 2018-08-31 21:27
 **/
@FeignClient(name = "item-service")
public interface CategoryClient extends CategoryApi {
}
