package com.lilb.loser.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lilb.loser.entity.User;
import com.lilb.loser.mapper.UserMapper;
import com.lilb.loser.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lilinbi
 * @since 2022-03-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    UserMapper userMapper;

    /**
     * 获取用户
     *
     * @param id id
     * @return {@link CompletableFuture}<{@link User}>
     */
    @Async
    @Override
    public CompletableFuture<User> get(Integer id) {
        User userEntity = userMapper.selectById(id);
        return CompletableFuture.completedFuture(userEntity);
    }

}
