## 第一个springBoot
- 创建项目并导入相关依赖，此项目中只勾选了web依赖
- 创建controller包，并且在其下创建controller
- 为了让程序能够识别到我们的controller,必须将主启动文件移动到这些包的同级目录下
- 启动

## Intellij IDEA 使用Spring-boot-devTools实现热部署
- 添加插件
```xml
  <!-- 热部署模块 -->
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-devtools</artifactId>
      <optional>true</optional> <!-- 这个网上说需要设置为 true 热部署才有效,实测没有也可以的 -->
  </dependency>
```

- Preferences > Build, Execution, Deployment > Compiler
勾选Build project automatically
  
- Shift+Ctrl+Alt+/(Mac是Cmd+Shift+A)
  选择registry，勾选 compiler.automake.allow.when.app.running
  
这样一来就无需反复重启服务器，有改变的时候只需重新编译程序就可以了
