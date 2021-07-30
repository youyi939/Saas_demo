package cn.lnfvc.core.controller;

import cn.lnfvc.core.pojo.KenLog;
import cn.lnfvc.core.service.LogService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public IPage<KenLog> selectLogPage(@RequestParam(name = "current") Integer current, @RequestParam(name = "size") Integer size){
        return logService.page(new Page<KenLog>(current,size));
    }


    @ApiImplicitParams({
            @ApiImplicitParam(name = "username",value = "操作者",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "operation",value = "操作",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "method",value = "方法",dataType = "String",paramType = "query")
    })
    @ApiOperation("模糊查询日志信息")
    @GetMapping(value = "/api/log/fuzzyQuery")
    public List<KenLog> fuzzyQuery(@RequestParam(name = "username") String username, @RequestParam(name = "operation") String operation, @RequestParam(name = "method") String method){
        return logService.findByNameOrOperationOrMethod(username,operation,method);
    }

}
