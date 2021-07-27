package cn.lnfvc.ken.mapper;


import cn.lnfvc.ken.entity.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: KenChen
 * @Description: 用户的mapper
 * @Date: Create in  2021/7/23 下午4:37
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
