#### 基于springmvc+ActiveMQ实现JMS消息的Queue和Topic示例

#### 运行本示例需要启动ActiveMQ（本例已在5.7.0下测试通过，下载地址http://activemq.apache.org/activemq-570-release.html）

#### 示例演示说明
1. 	启动JMS消息订阅方MQReader模块，进入MQReader目录，执行如下命令：
```
mvnw clean jetty:run
```
运行端口7080，可在pom.xml调整
2.  启动服务消费方WsClient模块，进入WsClient目录，执行如下命令：
```
mvnw clean jetty:run
```
运行端口7060，可在pom.xml调整
3.  启动MQWriter模块，进入MQWriter目录，执行如下命令：
```
mvnw clean jetty:run
```
运行端口7070，可在pom.xml调整


#### 示例结果
三个模块启动后，浏览器打开http://localhost:7060/WsClient/test，将调用TestController的test方法，每执行一次会调用一次上述模拟服务，注意观察MQReader控制台，是否有接收到JMS推送的SOAP消息。		