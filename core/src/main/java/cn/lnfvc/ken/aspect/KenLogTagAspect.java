package cn.lnfvc.ken.aspect;

import cn.lnfvc.ken.annotation.KenLogTag;
import cn.lnfvc.ken.pojo.KenLog;
import cn.lnfvc.ken.service.LogService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @Author: KenChen
 * @Description: 系统日志，切面处理类
 * @Date: Create in  2021/7/26 下午2:11
 */
@Aspect
@Component
public class KenLogTagAspect {

    @Autowired
    LogService logService;

    @Pointcut("@annotation(cn.lnfvc.ken.annotation.KenLogTag)")
    public void logPointCut() {

    }


    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        //执行方法
        Object result = point.proceed();
        //执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;

        //保存日志
        saveSysLog(point, time);

        return result;
    }

    /**
     * 保存log信息
     * @param joinPoint
     * @param time
     */
    public void saveSysLog(ProceedingJoinPoint joinPoint, long time){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        KenLogTag syslog = method.getAnnotation(KenLogTag.class);
        KenLog kenLog = new KenLog();

        if(syslog != null){
            //注解上的描述
            String operation = syslog.value();
            kenLog.setOperation(operation);
        }

        ObjectMapper mapper = new ObjectMapper();
        //请求的参数
        if(syslog.recordParams()){
            StringBuffer sb = new StringBuffer();
            Object[] args = joinPoint.getArgs();
            for(Object object:args){
                try{
                    if(mapper.writeValueAsString(object).length()<1000){
                        sb.append(mapper.writeValueAsString(object));
                        sb.append(",");
                    }else{
                        sb.append("bob");
                        sb.append(",");
                    }
                }catch (Exception e){

                }
            }
            String params = sb.toString();
            params = params.replaceAll("[\ud800\udc00-\udbff\udfff\ud800-\udfff]","");
            //保存参数
            kenLog.setParams(params);
        }

        //获取网络相关信息
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String ip = request.getHeader("Host");


        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();

        kenLog.setCreateDate(new Date());
        kenLog.setMethod(className+","+methodName);
        kenLog.setTime(time);
        kenLog.setUuid("");
        kenLog.setUsername("guest");
        kenLog.setIp(ip);

        System.out.println("\033[31;4m"
                + "注解描述："+syslog.value()+"\n"
                +"服务端IP："+ip+"\n"
                +"请求方法名："+className+","+methodName+" 方法执行时间："+time+ "\033[0m");

        logService.save(kenLog);
    }



}
