## 写在最前

**在这里记录了第二次学习SpringBoot的一些Demo，每个部分都有对应的readme.md记录了详细的步骤和注意事项**



## 用到的一些注解说明

### @SpringBootApplication

在程序的主入口上都有这样的一个注解，它是一个组合注解。
@SpringBootApplication等价于@SpringBootConfiguration、@EnableAutoConfiguration和@ComponentScan这三个注解。
@SpringBootApplication开启了spring的组件扫描和自动配置功能



### @Value
从配置文件中获取值，使用格式@Value("${name}")

### @Component
注册bean到容器中,多用于实体类中

### @Bean
标注在方法上，等价于spring的xml配置文件中的<bean>，作用为：注册bean对象

### @Configuration
声明这是一个配置类，相当于把该类作为spring的xml配置文件中的<beans>

### @ConfigurationProperties(prefix = " ")
将配置文件中配置的每一个属性的值，映射到这个组件中；
告诉SpringBoot将本类中的所有属性和配置文件中相关的配置进行绑定
prefix = " "参数就是配置文件中的属性 

### @Autowired
开启自动注入

### @RequestBody
将 HTTP 求正文插入方法中，使用适合的HttpMessageConverter将请求体写入某个对象。

### @ResponseBody
表示该方法的返回的结果直接写入 HTTP 响应正文中，对比@RequestMapping,无需路径跳转

### @Controller
告诉程序这是一个controller，并被spring接管

### @RestController
即@RestController是@ResponseBody和@Controller的组合注解。


## 用到的依赖
```xml
<dependencies>
    <!--web启动器依赖，必须-->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
        <exclusions>
            <exclusion>
                <groupId>org.junit.vintage</groupId>
                <artifactId>junit-vintage-engine</artifactId>
            </exclusion>
        </exclusions>
    </dependency>

    <!--读取配置文件所需-->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-configuration-processor</artifactId>
        <optional>true</optional>
    </dependency>

    <!--使用lombok-->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>

    <!--导入mybatis的使用依赖-->
    <dependency>
        <groupId>org.mybatis.spring.boot</groupId>
        <artifactId>mybatis-spring-boot-starter</artifactId>
        <version>2.1.1</version>
    </dependency>

    <!-- 导入druid数据库连接池依赖 -->
    <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>druid</artifactId>
        <version>1.1.21</version>
    </dependency>

    <!-- log4j日志信息 -->
    <dependency>
        <groupId>log4j</groupId>
        <artifactId>log4j</artifactId>
        <version>1.2.17</version>
    </dependency>

    <!-- 热部署模块 -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <optional>true</optional> 
    </dependency>

    <!-- pagehelper -->
    <dependency>
        <groupId>com.github.pagehelper</groupId>
        <artifactId>pagehelper-spring-boot-starter</artifactId>
        <version>1.2.5</version>
    </dependency>




</dependencies>

```

## 用到的plugin

```xml
<!--maven打包插件-->
<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
</plugin>
```

