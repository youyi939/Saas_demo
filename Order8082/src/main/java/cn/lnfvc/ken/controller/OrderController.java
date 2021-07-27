package cn.lnfvc.ken.controller;

import cn.lnfvc.ken.annotation.KenLogTag;
import cn.lnfvc.ken.entity.CommonResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: KenChen
 * @Description: 用户管理Order接口
 * @Date: Create in  2021/7/27 下午4:10
 */
@RestController
public class OrderController {


    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverUrl;

    @ApiOperation("Order调用根据ID获取用户接口")
    @KenLogTag("Order调用根据ID获取用户接口")
    @GetMapping(value = "/consumer/public/user/{id}")
    public CommonResult selectById(@PathVariable int id){
        System.out.println(serverUrl);
        return restTemplate.getForObject(serverUrl+"/public/user/"+id,CommonResult.class);
    }

}
