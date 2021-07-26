package cn.lnfvc.ken.demo.controller;

import cn.lnfvc.ken.demo.annotation.KenLogTag;
import cn.lnfvc.ken.demo.entity.dto.UserDTO;
import cn.lnfvc.ken.demo.entity.pojo.User;
import cn.lnfvc.ken.demo.entity.vo.CommonResult;
import cn.lnfvc.ken.demo.service.UserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
            @ApiImplicitParam(name = "current",value = "分页页数",dataType = "Integer",paramType = "query",required = true),
            @ApiImplicitParam(name = "size",value = "每页数据条数",dataType = "Integer",paramType = "query")
    })
    @KenLogTag("分页获取用户列表")
    @ApiOperation("分页查询用户列表")
    @GetMapping(value = "/public/user/selectUserPage")
    public CommonResult selectUserPage(@RequestParam(name = "current") Integer current, @RequestParam(name = "size") Integer size){
        return CommonResult.ok("分页查询成功").putDate((Page<User>) userService.page(new Page<User>(current,size)));
    }


    @ApiOperation("新建用户")
    @KenLogTag("新建用户")
    @PostMapping(value = "/public/user/save")
    public CommonResult save(@RequestBody UserDTO userDTO){
        userService.save(userDTO);
        return CommonResult.ok("新建用户成功");
    }



}
