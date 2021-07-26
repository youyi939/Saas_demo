package cn.lnfvc.ken.demo.service.impl;

import cn.lnfvc.ken.demo.mapper.UserMapper;
import cn.lnfvc.ken.demo.pojo.User;
import cn.lnfvc.ken.demo.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: KenChen
 * @Description:
 * @Date: Create in  2021/7/26 上午10:36
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    /**
     * 分页获取User列表
     * @param page
     * @return
     */
    @Override
    public IPage<User> page(Page<User> page) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        Page<User> userPage = userMapper.selectPage(page,queryWrapper);
        return userPage;
    }

}
