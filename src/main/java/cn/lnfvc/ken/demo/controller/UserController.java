package cn.lnfvc.ken.demo.controller;

import cn.lnfvc.ken.demo.annotation.KenLogTag;
import cn.lnfvc.ken.demo.entity.pojo.User;
import cn.lnfvc.ken.demo.entity.vo.CommonResult;
import cn.lnfvc.ken.demo.service.UserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: KenChen
 * @Description: 用户Controller
 * @Date: Create in  2021/7/26 上午10:25
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @KenLogTag("分页获取用户列表")
    @ApiOperation("分页查询用户列表")
    @GetMapping(value = "/public/selectUserPage")
    public CommonResult selectUserPage(){
        return CommonResult.ok("分页查询成功").putDate((Page<User>) userService.page(new Page<User>(1,3)));
    }

}
