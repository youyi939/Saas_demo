package cn.lnfvc.core.service.impl;

import cn.lnfvc.core.mapper.LogMapper;
import cn.lnfvc.core.pojo.KenLog;
import cn.lnfvc.core.service.LogService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: KenChen
 * @Description: Log服务实现类
 * @Date: Create in  2021/7/26 下午3:36
 */
@Service
public class LogServiceImpl implements LogService {
    @Autowired
    LogMapper logMapper;

    /**
     * 保存一条日志
     * @param kenLog
     */
    @Override
    public void save(KenLog kenLog) {
        logMapper.insert(kenLog);
    }

    /**
     * 分页查询日志
     * @param page
     * @return
     */
    @Override
    public IPage<KenLog> page(Page<KenLog> page) {
        QueryWrapper<KenLog> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        Page<KenLog> kenLogPage = logMapper.selectPage(page,queryWrapper);
        return  kenLogPage;
    }

    /**
     * 根据username，操作，方法名进行日志的模糊查询
     * @param username
     * @param operation
     * @param method
     * @return
     */
    @Override
    public List<KenLog> findByNameOrOperationOrMethod(String username, String operation, String method) {
        return logMapper.selectByLike(username,operation,method);
    }

}
