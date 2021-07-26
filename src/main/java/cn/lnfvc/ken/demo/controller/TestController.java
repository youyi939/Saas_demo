package cn.lnfvc.ken.demo.controller;

import cn.lnfvc.ken.demo.annotation.UserLogTag;
import cn.lnfvc.ken.demo.pojo.User;
import cn.lnfvc.ken.demo.pojo.dto.UserDTO;
import cn.lnfvc.ken.demo.pojo.vo.CommonResult;
import cn.lnfvc.ken.demo.service.UserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: KenChen
 * @Description:
 * @Date: Create in  2021/7/26 上午10:25
 */
@RestController
public class TestController {

    @Autowired
    UserService userService;

    @ApiOperation("分页查询用户列表")
    @GetMapping(value = "/test/selectPage")
    public CommonResult<Page<User>>  selectUserPage(){
        return new CommonResult<Page<User>>(200,"分页查询成功", (Page<User>) userService.page(new Page<User>(1,3)));
    }

}
