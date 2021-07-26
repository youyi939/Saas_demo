package cn.lnfvc.ken.demo.annotation;

import java.lang.annotation.*;

/**
 * @Author: KenChen
 * @Description: 自定义系统日志注解
 * @Date: Create in  2021/7/26 上午11:17
 */

@Target(ElementType.METHOD)             //元注解，该注解决定了此自定义注解在java程序中的合法位置
@Retention(RetentionPolicy.RUNTIME)     //
@Documented
public @interface UserLogTag {
    
}
