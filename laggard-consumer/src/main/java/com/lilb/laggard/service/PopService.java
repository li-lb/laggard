package com.lilb.laggard.service;


import com.lilb.laggard.entity.CommonResult;
import com.lilb.laggard.service.impl.PopFallbackServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * 支付服务
 *
 * @author li-lb
 * @date 2022/01/05
 */
@Component
@FeignClient(value = "laggard-provider", fallback = PopFallbackServiceImpl.class)
public interface PopService {
    @GetMapping(value = "/selectById/{id}")
    CommonResult selectById(@PathVariable("id") Integer id);
}
