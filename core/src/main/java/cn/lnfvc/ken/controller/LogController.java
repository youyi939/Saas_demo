package cn.lnfvc.ken.controller;

import cn.lnfvc.ken.annotation.KenLogTag;
import cn.lnfvc.ken.entity.CommonResult;
import cn.lnfvc.ken.pojo.KenLog;
import cn.lnfvc.ken.service.LogService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: KenChen
 * @Description: 日志Controller
 * @Date: Create in  2021/7/26 下午3:58
 */
@Api(tags = "日志接口")
@RestController
public class LogController {
    @Autowired
    LogService logService;


    //此注解用于解释参数
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current",value = "分页页数",dataType = "int",paramType = "query",required = true),
            @ApiImplicitParam(name = "size",value = "每页数据条数",dataType = "int",paramType = "query",required = true)
    })
    @ApiOperation(value = "分页查询日志")
    @GetMapping(value = "/api/log/selectLogPage")
    public CommonResult selectLogPage(@RequestParam(name = "current") Integer current, @RequestParam(name = "size") Integer size){
        return CommonResult.ok("分页查询日志成功").putDate((Page<KenLog>)logService.page(new Page<KenLog>(current,size)));
    }


    @ApiImplicitParams({
            @ApiImplicitParam(name = "username",value = "操作者",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "operation",value = "操作",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "method",value = "方法",dataType = "String",paramType = "query")
    })
    @ApiOperation("模糊查询日志信息")
    @GetMapping(value = "/api/log/fuzzyQuery")
    public CommonResult fuzzyQuery(@RequestParam(name = "username") String username,@RequestParam(name = "operation") String operation,@RequestParam(name = "method") String method){
        return CommonResult.ok("模糊查询成功").putDate(logService.findByNameOrOperationOrMethod(username,operation,method));
    }

}
