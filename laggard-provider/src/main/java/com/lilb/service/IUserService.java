package com.lilb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lilb.entity.User;

import java.util.concurrent.CompletableFuture;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author lilinbi
 * @since 2022-03-17
 */
public interface IUserService extends IService<User> {

    /**
     * 获取用户
     *
     * @param id id
     * @return {@link CompletableFuture}<{@link User}>
     */
    CompletableFuture<User> get(Integer id);

}
