# SpringCloud
基于springcloud搭建的微服务程序

## 使用技术
- 版本：springcloud Finchley.RELEASE
- 注册中心：eureka
- 负载均衡：（备选）ribbon


## 项目结构
- 注册中心 discovery
- 服务提供者 service-hello
- 负载均衡、服务消费者 service-ribbon
- 网关 gateway

## 启动项目

1. 启动discovery
2. 启动service-hello
3. 启动service-ribbon
4. 启动gateway

## 实现功能
通过注册中心的配置，可以在gateway模块，访问service和service2模块上的接口。
