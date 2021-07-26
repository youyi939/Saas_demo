package cn.lnfvc.ken.demo;

import cn.lnfvc.ken.demo.entity.pojo.KenLog;
import cn.lnfvc.ken.demo.service.LogService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * @Author: KenChen
 * @Description: 日志接口测试类
 * @Date: Create in  2021/7/26 下午3:47
 */
@SpringBootTest
public class LogTest {

    @Autowired
    LogService logService;

    @Test
    public void selectLogPage(){
        Page<KenLog> page = new Page(0,3);
        System.out.println(logService.page(page));
    }

}
