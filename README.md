# atshop
基于springcloud的商城类网站
目前网上有很多快速开发平台，atshop目的在于开发解耦应用

## 2018-01-25
初始化应用工程，添加注册中心，工作流模块，用户管理模块，



部署：
dockerfile 

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

业务部分开发：
参考at-web模块，基础设施建设在at-infrastructure

检索部分使用es
如果是使用的云主机，开发配置较低，可以通过修改es的相关配置
网上有说添加环境变量：-e ES_JAVA_OPTS="-Xms256m -Xmx256m"指定堆内存即可
实测logs中有报错，不识别
可以通过修改es的jvm.options文件，例如：vi /var/lib/docker/overlay2/05408c9d3929a4fba2679170ea59004fcad7b0ab810c992df41f6cdabf092935/diff/usr/share/elasticsearch/config/jvm.options
亲测可用

kibana