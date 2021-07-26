package cn.lnfvc.ken.demo.pojo.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: KenChen
 * @Description:
 * @Date: Create in  2021/7/25 下午5:25
 */
@ApiModel("User的DTO类，面向外部")
@Data
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private Integer sort;
}
