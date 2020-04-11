## springboot整合mybatis

### 在整合druid前提下添加mybtis依赖
既然使用druid那必然要进行config
```
<!-- mybatis依赖 -->
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>2.1.1</version>
</dependency>
```

### 使用EasyCode插件自动生成文件
- 注意选择package和path,这两个都要设置！

### 在配置文件中添加关于mybatis的配置，指定配置文件所在地址
```yaml
mybatis:
  mapper-locations: classpath:/mapper/*Dao.xml
  typeAliasesPackage: com.lucius.entity
```
### 在dao接口上添加@Mapper注解
### 在启动类里面加上@MapperScan("com.lucius.dao")注解。
### localhost:8080/user/selectOne?id=41 

