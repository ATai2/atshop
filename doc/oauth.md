
认证服务器

![](medie/3.PNG)
 app 授权模式
![](medie/9.PNG)

web授权
![](medie/10.PNG)
分2部分，一个是用户认证还有客户端认证

隐式授权，把令牌交给浏览器
![](medie/11.PNG)

http://authserver.com:9030/oauth/authorize?client_id=admin&redirect_uri=http://admin.com:8080/oauth/callback&
response_type=code&
state=aaa

admin服务校验请求和令牌请求















