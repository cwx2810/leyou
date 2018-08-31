package com.leyou.page.client;

import com.leyou.item.api.BrandApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author: LieutenantChen
 * @create: 2018-08-31 21:24
 **/
@FeignClient(name = "item-service")
public interface BrandClient extends BrandApi {
}
