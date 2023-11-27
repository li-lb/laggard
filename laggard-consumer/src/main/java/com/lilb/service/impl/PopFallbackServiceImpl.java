package com.lilb.service.impl;


import com.lilb.entity.CommonResult;
import com.lilb.service.PopService;
import org.springframework.stereotype.Component;

/**
 * 回退服务
 *
 * @author li-lb
 * @date 2022/01/05
 */
@Component
public class PopFallbackServiceImpl implements PopService {
    @Override
    public CommonResult selectById(Integer id) {
        return new CommonResult<>(44444, "服务降级返回,---PaymentFallbackService");
    }
}
