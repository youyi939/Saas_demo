package cn.lnfvc.core.blockhandler;

import cn.lnfvc.commons.entity.CommonResult;
import cn.lnfvc.commons.entity.User;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


/**
 * @Author: KenChen
 * @Description: sentinel的blockHandler自定义处理
 * @Date: Create in  2021/8/2 下午2:12
 */
public class PaymentBlockHandler {

    /**
     * 全局通用blockHandler
     * @param e
     * @return
     */
    public static CommonResult globalHandlerException(Integer current, Integer size, BlockException e){
        return new CommonResult(404,e.getClass().getCanonicalName()+"服务暂不可用");
    }


    public static String HandlerExpectionA(BlockException exception){
        return "Client      自定义HandlerExpection";
    }

}
