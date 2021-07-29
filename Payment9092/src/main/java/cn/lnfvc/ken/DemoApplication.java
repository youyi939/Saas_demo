package cn.lnfvc.ken;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

        //当前JVM占用的内存总数(M)
        double total = (Runtime.getRuntime().totalMemory()) / (1024.0 * 1024);

        //JVM最大可用内存总数(M)

        double max = (Runtime.getRuntime().maxMemory()) / (1024.0 * 1024);

        //JVM空闲内存(M)

        double free = (Runtime.getRuntime().freeMemory()) / (1024.0 * 1024);

        //可用内存内存(M)

        double mayuse=(max - total + free);

        //已经使用内存(M)

        double used=(total-free);


        System.out.println("JVM最大可用内存数:"+max+" M");

        System.out.println("JVM已经使用的内存:"+used+" M");

        System.out.println("JVM空闲内存数:"+free+" M");

        System.out.println("可用内存数:"+mayuse+" M");


    }

}
