package cn.lnfvc.ken.demo.entity.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: KenChen
 * @Description:
 * @Date: Create in  2021/7/23 下午4:37
 */
@ApiModel("用户实体类，面向内部")
@Data
@AllArgsConstructor
@TableName("user")
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
