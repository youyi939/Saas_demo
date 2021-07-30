package cn.lnfvc.core.controller;

import cn.lnfvc.core.annotation.KenLogTag;
import cn.lnfvc.commons.entity.CommonResult;
import cn.lnfvc.commons.entity.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: KenChen
 * @Description: 用户管理Order接口
 * @Date: Create in  2021/7/27 下午4:10
 */
@RestController
@RefreshScope
public class OrderController {


    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverUrl;

    @ApiOperation("Order调用根据ID获取用户接口")
    @KenLogTag("Order调用根据ID获取用户接口")
    @GetMapping(value = "/consumer/public/user/{id}")
    public CommonResult selectById(@PathVariable int id){
        String url = serverUrl+"/public/user/"+id;
        return restTemplate.getForObject(url,CommonResult.class);
    }

    @ApiOperation("Order调用分页获取用户列表接口")
    @KenLogTag("Order调用分页获取用户列表接口")
    @GetMapping(value = "/consumer/public/user")
    public CommonResult selectUserPage(@RequestParam(name = "current") Integer current, @RequestParam(name = "size") Integer size){
        String url = serverUrl+"/public/user?current={current}&size={size}";
        Map map = new HashMap();
        map.put("current",current);
        map.put("size",size);
        return restTemplate.getForObject(url,CommonResult.class,map);
    }


    @ApiOperation("Order调用新建用户")
    @KenLogTag("Order调用新建用户")
    @PostMapping(value = "/consumer/public/user")
    public CommonResult save(@RequestBody User user){
        String url = serverUrl+"/public/user";
        return restTemplate.postForObject(url,user,CommonResult.class);
    }


    @ApiOperation("Order调用批量删除用户")
    @KenLogTag("Order调用批量删除用户")
    @DeleteMapping(value = "/consumer/public/user")
    public CommonResult removeByIds(@RequestBody ArrayList<Integer> ids){
        String url = serverUrl+"/public/user/removeByIds";
        return restTemplate.postForObject(url,ids,CommonResult.class);
    }


    @ApiOperation("Order调用根据ID删除用户")
    @KenLogTag("Order调用根据ID删除用户")
    @DeleteMapping(value = "consumer/public/user/{id}")
    public CommonResult removeById(@PathVariable int id){
        String url = serverUrl+"/public/user/"+id;
        return restTemplate.postForObject(url,null,CommonResult.class);
    }


    @ApiOperation("Order调用根据ID更新用户信息")
    @KenLogTag("Order调用根据ID更新用户信息")
    @PutMapping(value = "/consumer/public/user")
    public CommonResult update(@RequestBody User user){
        String url = serverUrl+"/public/user/update";
        return restTemplate.postForObject(url,user,CommonResult.class);
    }


}
