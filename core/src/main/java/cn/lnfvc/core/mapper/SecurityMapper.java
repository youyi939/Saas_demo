package cn.lnfvc.core.mapper;

import cn.lnfvc.core.pojo.KenLog;
import cn.lnfvc.core.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: KenChen
 * @Description:
 * @Date: Create in  2021/8/6 下午4:34
 */
@Mapper
public interface SecurityMapper extends BaseMapper<User> {
}
