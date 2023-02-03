package com.lilb.laggard.controller;

import com.lilb.laggard.entity.User;
import com.lilb.laggard.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * 用户控制器
 *
 * @author li-lb
 * @author lilinbi
 * @date 2022/01/17
 * @since 2022-03-17
 */
@RestController
@Slf4j
@CacheConfig(cacheNames = {"user"})
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService iUserService;


    /**
     * 查询出一条数据并且添加到缓存
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @Cacheable(key = "#id", unless = "#result == null")
    public User get(String id) {
        log.info("如果没有缓存，就会调用下面方法，如果有缓存，则直接输出，不会输出此段话");
        return iUserService.getById(id);
    }

    /**
     * 删除一个缓存
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/del", method = RequestMethod.GET)
    @CacheEvict(key = "#id")
    public void del(String id) {
        iUserService.removeById(id);
        log.info("删除成功");
    }

    /**
     * 添加一条保存的数据到缓存，缓存的key是当前user的id
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @CachePut(key = "#result.id")
    public User save(User user) {
        iUserService.save(user);
        return user;
    }

}
