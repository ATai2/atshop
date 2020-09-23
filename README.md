# atshop
基于springcloud的商城类网站

## 2018-01-25
初始化应用工程，添加注册中心，工作流模块，用户管理模块，

项目规划：
* 后台管理： ng-admin
* 单点登录
* 站内搜索
* 电影信息网站
* 商品详情
* 用户管理

部署：
dockerfile 

JMS:
activeMQ

打包后放置于应用文件夹，准备dockerfile。具体实现方式，请使用脚本，推荐groovy或者python

使用的docker镜像：
1. dockerhub：
2. 本地应用镜像：

配置：
* mysql
> docker run --name mysql -p 12345:3306 -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql:5.6.35
* redis

# 前端部分
### 后台管理
后台管理采用vue-element-admin,修改部分功能。

# 数据抓取
数据源：


服务发现切换到alibaba的nacos


