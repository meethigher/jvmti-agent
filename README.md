执行命令打包，生成agent类

```sh
mvn clean package
```

idea启动`TestMain`，获取`PID`，将`PID`放入`Attacher`中，启动。再次查看`TestMain`执行日志，会发现方法内容已经被修改了。