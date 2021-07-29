package cn.lnfvc.ken.controller;

import cn.lnfvc.ken.annotation.KenLogTag;
import cn.lnfvc.ken.entity.CommonResult;
import cn.lnfvc.ken.entity.pojo.User;
import cn.lnfvc.ken.service.UserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @Author: KenChen
 * @Description: 用户Controller
 * @Date: Create in  2021/7/26 上午10:25
 */
@Api(tags = "用户管理接口")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "current",value = "分页页数",dataType = "int",paramType = "query",required = true),
            @ApiImplicitParam(name = "size",value = "每页数据条数",dataType = "int",paramType = "query",required = true)
    })
    @KenLogTag("分页获取用户列表")
    @ApiOperation("分页查询用户列表")
    @GetMapping(value = "/public/user")
    public CommonResult selectUserPage(@RequestParam(name = "current") Integer current, @RequestParam(name = "size") Integer size){
        return CommonResult.ok("分页查询成功").putDate((Page<User>) userService.page(new Page<User>(current,size)));
    }


    @ApiOperation("新建用户")
    @KenLogTag("新建用户")
    @PostMapping(value = "/public/user")
    public CommonResult save(@RequestBody User user){
        userService.save(user);
        return CommonResult.ok("新建用户成功");
    }


    @ApiOperation("根据ID更新用户信息")
    @KenLogTag("根据ID更新用户信息")
    @PutMapping(value = "/public/user")
    public CommonResult update(@RequestBody User user){
        userService.updateById(user);
        return CommonResult.ok("更新用户信息成功");
    }


    @ApiOperation("根据ID删除用户")
    @KenLogTag("删除用户")
    @DeleteMapping(value = "/public/user/{id}")
    public CommonResult removeById(@PathVariable int id){
        userService.removeById(id);
        return CommonResult.ok("删除用户成功");
    }


    @ApiOperation("批量删除用户")
    @KenLogTag("批量删除用户")
    @DeleteMapping(value = "/public/user")
    public CommonResult removeByIds(@RequestBody ArrayList<Integer> ids){
        userService.removeByIds(ids);
        return CommonResult.ok("删除用户成功");
    }


    @ApiOperation("根据ID获取用户")
    @KenLogTag("根据ID获取用户")
    @GetMapping(value = "/public/user/{id}")
    public CommonResult selectById(@PathVariable int id){
        return CommonResult.ok("获取用户成功").putDate(userService.getById(id));
    }


}
