package cn.lnfvc.core.service;

import cn.lnfvc.core.pojo.User;

/**
 * @Author: KenChen
 * @Description:
 * @Date: Create in  2021/8/6 下午4:33
 */
public interface SecurityService {
    /**
     * 根据用户名查询用户
     * @param name
     * @return
     */
    User getByName(String name);
}
