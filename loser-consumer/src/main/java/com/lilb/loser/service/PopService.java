package com.lilb.loser.service;


import com.lilb.loser.entity.CommonResult;
import com.lilb.loser.service.impl.PopFallbackServiceImpl;
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
@FeignClient(value = "loser-provider", fallback = PopFallbackServiceImpl.class)
public interface PopService {
    @GetMapping(value = "/selectById/{id}")
    public CommonResult selectById(@PathVariable("id") Integer id);
}
