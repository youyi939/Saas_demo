package cn.lnfvc.ken.service;

import cn.lnfvc.ken.entity.pojo.KenLog;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * @Author: KenChen
 * @Description: 日志服务类
 * @Date: Create in  2021/7/26 下午3:29
 */
public interface LogService {

    /**
     * 保存一条系统日志
     * @param kenLog
     */
    void save(KenLog kenLog);

    /**
     * 分页获取系统日志
     * @param page
     * @return
     */
    IPage<KenLog> page(Page<KenLog> page);


    /**
     * 根据操作者名字，操作，或方法进行日志的模糊查询
     * @param username
     * @param operation
     * @param method
     * @return
     */
    List<KenLog> findByNameOrOperationOrMethod(String username, String operation, String method);

}
