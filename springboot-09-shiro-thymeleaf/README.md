请看我的博客：
## 导入依赖
```xml
<!-- thymeleaf-extras-shiro -->
<dependency>
    <groupId>com.github.theborakompanioni</groupId>
    <artifactId>thymeleaf-extras-shiro</artifactId>
    <version>2.0.0</version>
</dependency>
```

```html
<html xmlns:th="http://www.thymeleaf.org"
	  xmlns:shiro="http://www.pollix.at/thymeleaf/shiro" >
```

### 在shiro配置中添加bean
```

/*
 * 配置ShiroDialect，用于Thymeleaf和Shiro标签配合使用
 */
@Bean
public ShiroDialect getShiroDialect() {
    return new ShiroDialect();
}
```

搞定了！