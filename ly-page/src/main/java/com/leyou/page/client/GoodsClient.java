package com.leyou.page.client;

import com.leyou.item.api.GoodsApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author: LieutenantChen
 * @create: 2018-08-31 21:28
 **/
@FeignClient(name = "item-service")
public interface GoodsClient extends GoodsApi {
}
