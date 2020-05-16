# springboot 整合redis
# 1.导入相关依赖
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
```
springboot2.0之后默认使用的不再是jedis而是lettuce了！如果要使用jedis,那么依赖与此不同请自行搜索。

# 2.redi配置文件
```yaml
# Redis数据库索引（默认为0）
spring.redis.database=0 
# Redis服务器地址
spring.redis.host=121.***.**.***
# Redis服务器连接端口
spring.redis.port=6379 
# Redis服务器连接密码（默认为空）
spring.redis.password=***
```
注意事项：
- 如果你的redis在你的服务器上，那么host就为你的服务器地址
- 如果你设置了redis的密码，那么password也需要设置
- 想要本地使用服务器上的redis还需要以下四个配置
  - 打开你的redis配置文件 vim redis.config
  - bind 127.0.0.1 将这句注视掉（他指定了唯一访问端口，默认是本机。注释掉之后意味着可以远程访问）
  - protected-mode no  把yes改成no （允许外网访问）
  - daemonize yes  把no改成yes （后台运行）
  - firewall-cmd --zone=public --add-port=6379/tcp --permanent （开启防火墙端口，记得重启防火墙`firewall-cmd --reload`才会生效）

# 3.简单源码分析
在autoConfig里面找到redis的配置类
```java
public class RedisAutoConfiguration {

	@Bean
//这个注释的意思是如果自己没有定义redisTemplate的类，那么就使用默认的
	@ConditionalOnMissingBean(name = "redisTemplate")
	public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory)
			throws UnknownHostException {
		RedisTemplate<Object, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(redisConnectionFactory);
		return template;
	}

	@Bean
	@ConditionalOnMissingBean
	public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory)
			throws UnknownHostException {
		StringRedisTemplate template = new StringRedisTemplate();
		template.setConnectionFactory(redisConnectionFactory);
		return template;
	}

}

```
可以看到配置类里面提供了两个Template，可以方便我们快速使用。由于redis是string类型的数据库，因此StringRedisTemplate使用更多一些。
实例化之后有很多自带的方法，能够非常方便的进行操作。
# 4.在test中进行简单测试
```java
@SpringBootTest
class Springboot11RedisApplicationTests {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    void contextLoads() {
        stringRedisTemplate.opsForValue().set("name","lucius");
        System.out.println(stringRedisTemplate.opsForValue().get("name"));
    }
}
```
此时在服务器中进行查询，也能够争取查询到相关数据。
说明：
如果使用的是RedisTemplate，那么我们在服务器上查询的结果往往是`\xac\xed\x00\x05t\x00\`这种情况，原因是什么呢？
RedisTemplate模板类在操作redis时默认使用存取序列化的方式为org.springframework.data.redis.serializer.JdkSerializationRedisSerializer来进行序列化。
StringRedisTemplate模板类在操作redis时默认使用存取序列化的方式为org.springframework.data.redis.serializer.StringRedisSerializer 会自动去掉\xac\xed\x00\x05t\x00前缀
解决这种问题的方法有两种：
- 直接使用StringRedisTemplate
- 修改RedisTemplate的序列化方式,或者自定义RedisTemplate

# 5.自定义一个redisUtil