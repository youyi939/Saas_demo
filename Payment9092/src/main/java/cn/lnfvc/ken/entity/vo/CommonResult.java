package cn.lnfvc.ken.entity.vo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: KenChen
 * @Description: 通用返回对象
 * @Date: Create in  2021/7/26 上午10:26
 */

@ApiModel("通用返回对象")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 返回成功调用
     * @param message 消息
     * @return
     */
    public static CommonResult ok(String message){
       CommonResult commonResult = new CommonResult();
       commonResult.setCode(200);
       commonResult.setMessage(message);
       return commonResult;
    }

    /**
     * 返回失败时调用
     * @param message
     * @return
     */
    public static CommonResult error(String message){
        CommonResult commonResult = new CommonResult();
        commonResult.setCode(500);
        commonResult.setMessage(message);
        return commonResult;
    }

    /**
     * 链式调用时插入数据
     * @param value
     * @return
     */
    public CommonResult putDate(T value){
        setData(value);
        return this;
    }

}
