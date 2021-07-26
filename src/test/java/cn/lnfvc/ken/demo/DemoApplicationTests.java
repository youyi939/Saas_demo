package cn.lnfvc.ken.demo;

import cn.lnfvc.ken.demo.mapper.UserMapper;
import cn.lnfvc.ken.demo.pojo.User;
import cn.lnfvc.ken.demo.pojo.dto.UserDTO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {


    @Autowired
    private UserMapper userMapper;

    /**
     * 查询全部
     */
    @Test
    public void selectAll(){
        System.out.println("--------SelectAll method test-------");
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    /**
     * 根据ID查询
     */
    @Test
    public void selectById(){
        System.out.println("--------SelectById method test-------");
        User user = userMapper.selectById(1);
        System.out.println(user.toString());
    }

    /**
     * 批量删除
     */
    @Test
    public void deleteByIds(){
        System.out.println("--------DeleteByIds method test-------");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <3 ; i++) {
            list.add(i);
        }
        userMapper.deleteBatchIds(list);
    }



    @Test
    public void beanUtilsTest(){
       UserDTO userDTO = new UserDTO((long) 1,"ken1",10);
       User user = new User((long) 1,"ken",21,"123.com");

        System.out.println(userDTO.toString());
        System.out.println(user.toString());

        BeanUtils.copyProperties(userDTO,user);

        System.out.println("---------------------------");

        System.out.println(userDTO.toString());
        System.out.println(user.toString());

    }


    @Test
    public void queryWrapperTest(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("age",20);

        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    /**
     * 分页查询
     */
    @Test
    public void selectPage(){
        Page<User> page = new Page<>(1, 3);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        Page<User> userIPage = userMapper.selectPage(page, queryWrapper);

        System.out.println(userIPage.toString());
        System.out.println("总条数"+userIPage.getTotal());
        System.out.println(userIPage.getRecords());

    }



}
