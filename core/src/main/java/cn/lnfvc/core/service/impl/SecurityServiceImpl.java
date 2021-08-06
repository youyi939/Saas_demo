package cn.lnfvc.core.service.impl;

import cn.lnfvc.core.mapper.SecurityMapper;
import cn.lnfvc.core.pojo.User;
import cn.lnfvc.core.service.SecurityService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: KenChen
 * @Description:
 * @Date: Create in  2021/8/6 下午4:34
 */
@Service
public class SecurityServiceImpl implements SecurityService {

    @Autowired
    SecurityMapper securityMapper;

    @Override
    public User getByName(String name) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getName,name);
        return securityMapper.selectOne(queryWrapper);
    }
}
