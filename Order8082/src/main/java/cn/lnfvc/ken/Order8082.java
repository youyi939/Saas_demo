package cn.lnfvc.ken;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: KenChen
 * @Description:
 * @Date: Create in  2021/7/27 下午4:09
 */
@EnableDiscoveryClient
@EnableSwagger2
@SpringBootApplication
public class Order8082 {
    public static void main(String[] args) {
        SpringApplication.run(Order8082.class,args);
    }
}
