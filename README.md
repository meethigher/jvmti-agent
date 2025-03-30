项目模块说明

* application
  * springboot应用，启动8080端口，任意get接口均返回`init` 
* application-agent
  * attach到springboot的进程，将get接口返回值修改为`hello, world`
* dynamic-agent-test
  * 验证动态字节码。启动`TestMain.java`，查看日志，获取到`PID`。将`PID`放入`AttacherMain`中，启动`AttacherMain`，再次查看日志，会发现日志输出已被修改。


执行命令打包，生成agent.jar，在attach时，需要将agent.jar加载到目标jvm，才能进行内容修改。

```sh
mvn clean package
```

idea启动`TestMain`，获取`PID`，将`PID`放入`Attacher`中，启动。再次查看`TestMain`执行日志，会发现方法内容已经被修改了。