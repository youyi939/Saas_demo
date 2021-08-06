package cn.lnfvc.core.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: KenChen
 * @Description:
 * @Date: Create in  2021/2/26 上午10:11
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginData {
    private String username;
    private String password;
}
