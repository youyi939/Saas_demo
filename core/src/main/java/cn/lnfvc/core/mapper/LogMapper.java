package cn.lnfvc.core.mapper;

import cn.lnfvc.commons.entity.KenLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: KenChen
 * @Description: 日志的mapper
 * @Date: Create in  2021/7/26 下午3:41
 */
@Mapper
public interface LogMapper extends BaseMapper<KenLog> {

    @Select("select * from ken_log where username  like concat ('%',#{username},'%') or operation LIKE concat ('%',#{operation},'%') or method like concat ('%',#{method},'%')")
    List<KenLog> selectByLike(@Param("username") String username, @Param("operation") String operation, @Param("method") String method);

}
