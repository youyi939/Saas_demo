# Saas_demo
## 项目说明：  
#### 基于SpringCloud的后端项目模版  

* 持久层：mybatis-plus Mysql
* 服务注册中心：Nacos
* 接口文档：Swagger2

***
#### 模块说明
* cloud-api-commons  
公用模块：提供了CommonResult通用返回对象
* core  
核心模块：在这里自定义了系统日志注解。未来的注解或者工具类也会放在这里。
* Payment9092  
服务提供者，完成具体的业务模块。并注册进Naocs服务注册中心。方便水平扩展。
* Order8082
消费者。注册进Nacos，前端调用此模块的接口，此模块再从Nacos注册中心拉取服务列表
。再做具体的功能调用

***
#### 接口说明
* swagger 文档地址：http://127.0.0.1:port/swagger-ui.html#/
