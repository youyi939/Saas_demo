package cn.lnfvc.ken.demo.entity.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: KenChen
 * @Description:
 * @Date: Create in  2021/7/26 下午6:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("用户更新DTO")
public class UserUpdateDTO {

    @ApiModelProperty("用户ID")
    private Integer id;

    @ApiModelProperty("用户名称")
    private String name;

    @ApiModelProperty("用户年龄")
    private int age;


    @ApiModelProperty("用户Email")
    private String email;
}
