package cn.lnfvc.ken.demo.service;

import cn.lnfvc.ken.demo.pojo.User;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @Author: KenChen
 * @Description:
 * @Date: Create in  2021/7/26 上午10:33
 */

public interface UserService {


    /**
     * 分页获取用户列表
     * @param page
     * @return
     */
    IPage<User> page(Page<User> page);

}
