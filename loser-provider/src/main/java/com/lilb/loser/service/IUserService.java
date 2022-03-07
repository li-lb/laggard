package com.lilb.loser.service;

import com.lilb.loser.entity.UserEntity;

import java.util.concurrent.CompletableFuture;

/**
 * 用户
 *
 * @author lilinbi
 * @date 2022/03/07
 */
public interface IUserService {

    /**
     * 获取用户
     *
     * @param id id
     * @return {@link CompletableFuture}<{@link UserEntity}>
     * @throws Exception 异常
     */
    CompletableFuture<UserEntity> get(Integer id) throws Exception;

}
