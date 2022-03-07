package com.lilb.loser.service.impl;

import com.lilb.loser.dao.intf.UserDao;
import com.lilb.loser.entity.UserEntity;
import com.lilb.loser.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

/**
 * 用户
 *
 * @author lilinbi
 * @date 2022/03/07
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserDao userDao;

    /**
     * 获取用户
     *
     * @param id id
     * @return {@link CompletableFuture}<{@link UserEntity}>
     * @throws Exception 异常
     */
    @Async
    @Override
    public CompletableFuture<UserEntity> get(Integer id) throws Exception {
        UserEntity userEntity = userDao.selectById(id);
        return CompletableFuture.completedFuture(userEntity);
    }
}
