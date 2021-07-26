package cn.lnfvc.ken.demo.mapper;

import cn.lnfvc.ken.demo.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: KenChen
 * @Description:
 * @Date: Create in  2021/7/23 下午4:37
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
