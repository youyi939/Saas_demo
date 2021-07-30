package cn.lnfvc.core.service;

import cn.lnfvc.commons.entity.User;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.ArrayList;

/**
 * @Author: KenChen
 * @Description: 用户服务类
 * @Date: Create in  2021/7/26 上午10:33
 */

public interface UserService {


    /**
     * 分页获取用户列表
     * @param page
     * @return
     */
    IPage<User> page(Page<User> page);

    /**
     * 新建用户
     * @param user
     */
    void save(User user);

    /**
     * 根据ID更新用户信息
     * @param user
     */
    void updateById(User user);

    /**
     * 根据ID查询用户
     * @param id
     */
    User getById(Integer id);

    /**
     * 根据ID删除用户
     * @param id
     */
    void removeById(int id);

    /**
     * 根据ID的List 批量删除用户
     * @param ids
     */
    void removeByIds(ArrayList<Integer> ids);

    /**
     * 根据ids，批量查询用户
     * @param page
     * @param ids
     * @return
     */
    IPage<User> pageByIds(Page<User> page, ArrayList<Integer> ids);

}
