package com.lilb.loser.service.impl;


import com.lilb.loser.entity.CommonResult;
import com.lilb.loser.service.PopService;
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
