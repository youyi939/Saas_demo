package cn.lnfvc.ken.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: KenChen
 * @Description: User的数据传输类
 * @Date: Create in  2021/7/25 下午5:25
 */

@Data
@AllArgsConstructor
@ApiModel(value = "User的Add DTO类，面向外部")
public class UserDTO {

    @ApiModelProperty("用户名称")
    private String name;

    @ApiModelProperty("用户年龄")
    private int age;


    @ApiModelProperty("用户Email")
    private String email;

}
