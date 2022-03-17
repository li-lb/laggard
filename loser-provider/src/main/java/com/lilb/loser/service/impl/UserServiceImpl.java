package com.lilb.loser.service.impl;

import com.lilb.loser.entity.User;
import com.lilb.loser.mapper.UserMapper;
import com.lilb.loser.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lilinbi
 * @since 2022-03-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
