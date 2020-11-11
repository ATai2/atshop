用户管理：

权限设计
at-auth
策略选择：
    token获取


api访问控制：
- ACL Access Control lists
简单易用

- RBAC  Role Based Access Control
引入角色概念，简化管理

流控 认证 审计  授权  业务逻辑

# 流控
流量控制
sentinel或者自定义guava

# 认证：

认证信息：
username:jojo
password:123456
组合成:   jojo:123456
Base64加密： lakdfjaldjfla
放入请求头：Authorization: Basic lakdfjaldjfla


密码加密：
MD5属于指纹摘要---不安全
AES---对称加密

盐---为了解决相同密码，加密结果是一样的


https:
keytool -genkeypair -alias jojo -keyalg RSA -keystore jojo.key 

``` yaml
server:
  port: 9010
  ssl:
    key-store: classpath:jojo.key
    key-store-password: asdfasdf
    key-password: asdfasdf
```

# 审计
