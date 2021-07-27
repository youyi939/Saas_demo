package cn.lnfvc.ken.demo.service.impl;

import cn.lnfvc.ken.demo.entity.dto.UserDTO;
import cn.lnfvc.ken.demo.entity.dto.UserUpdateDTO;
import cn.lnfvc.ken.demo.mapper.UserMapper;
import cn.lnfvc.ken.demo.entity.pojo.User;
import cn.lnfvc.ken.demo.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;

/**
 * @Author: KenChen
 * @Description: user服务实现类
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

    /**
     * 新建用户
     * @param userAddDTO
     */
    @Override
    public void save(UserDTO userAddDTO) {
        User user = new User();
        BeanUtils.copyProperties(userAddDTO,user);
        System.out.println("User信息："+user.toString());
        userMapper.insert(user);
    }

    /**
     * 根据ID更新用户信息
     * @param userUpdateDTO
     */
    @Override
    public void updateById(UserUpdateDTO userUpdateDTO) {
        User user = userMapper.selectById(userUpdateDTO.getId());
        BeanUtils.copyProperties(userUpdateDTO,user);
        userMapper.updateById(user);
    }

    /**
     * 根据ID查询用户
     * @param id
     * @return
     */
    @Override
    public User getById(Integer id) {
        return null;
    }

    /**
     * 根据ID删除用户
     * @param id
     */
    @Override
    public void removeById(int id) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getId,id);
        userMapper.delete(queryWrapper);
    }

    /**
     * 根据IDS，批量删除用户
     * @param ids
     */
    @Override
    public void removeByIds(ArrayList<Integer> ids) {
        userMapper.deleteBatchIds(ids);
    }

    /**
     * 根据IDS，批量查询用户
     * @param page
     * @param ids
     * @return
     */
    @Override
    public IPage<User> pageByIds(Page<User> page, ArrayList<Integer> ids) {
        return null;
    }

}
