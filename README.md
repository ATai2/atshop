# atshop
基于springcloud的商城类网站
目前网上有很多快速开发平台，atshop目的在于开发解耦应用
全部重构中

文件服务器：MinIO

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

# 微服务及端口配置
at-user:9120



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


at-auth
用户和应用权限



at-ws:
websocket

kibana

# 结构
对于后端管理类项目，业务并不是太复杂，而且往往有数据库类型的迁移问题，因此选用hibernate最为持久层框架，业务层选用mybatis分模块进行开发

需要高效检索的数据同步es
数据库选择对应的同步插件。可供选择的插件包括：
1）mysql、oracle选择 logstash-input-jdbc 插件。
2）mongo选择 mongo-connector工具

代码生成器

测试模块
selenium 


# metrics  tracing  logging
## metrics
时间上聚合，每分钟，小时，天等维度进行数据聚合
## tracing
一次请求的链路溯源
## logging
离散的文字信息



session共享


















