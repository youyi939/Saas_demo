package cn.lnfvc.core.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Author: KenChen
 * @Description: 系统日志对象
 * @Date: Create in  2021/7/26 下午2:17
 */

@Data
@ApiModel("日志实体类")
public class KenLog {

    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "id")
    private int id;

    @ApiModelProperty(value = "操作人")
    private String username;

    @ApiModelProperty(value = "操作人ID")
    private String uuid;

    @ApiModelProperty(value = "操作")
    private String operation;

    @ApiModelProperty(value = "方法")
    private String method;

    @ApiModelProperty(value = "参数")
    private String params;

    @ApiModelProperty(value = "时长")
    private Long time;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    @ApiModelProperty(value = "ipAndPort")
    private String ip;

}
