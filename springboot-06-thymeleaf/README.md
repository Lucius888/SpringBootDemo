## springBoot整合Themeleaf

### 导入相关依赖并进行相关配置
这个demo是基于mybatis进行整合的
pom.xml:
```xml
<!--thymeleaf-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```
application.yaml:
关闭缓存，在调试的时候关闭。
```yaml
spring:
  thymeleaf:
    cache: false
```

### 生成相关文件导入静态资源
根据数据库使用Easycode生成相应的实体类和controller;
导入相关静态资源,springboot默认在以下四个地址寻找静态资源
```
"classpath:/META-INF/resources/"
"classpath:/resources/"
"classpath:/static/"
"classpath:/public/"
```
### 具体写controller进行页面跳转
坑：Easycode自动生成的controller是使用@RESTController,但是这里返回一个页面而不是一个值，如果只是使用@RestController注解Controller，则Controller中的方法无法返回jsp页面，配置的视图解析器InternalResourceViewResolver不起作用，返回的内容就是Return 里的内容。
因此一定要将其改为@Controller!!!

### 写具体的跳转页面，注意要放到刚才提到的那四个地址下