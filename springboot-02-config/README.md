## springBoot中配置文件的使用
在resource文件夹下有个application.properties的配置文件，可以在application.properties添加自定义属性。
然后可以在controller中使用@Value(${})注解来自动自动注入。

## yaml配置文件
springboot中推荐使用yaml格式的配置文件进行配置
### yaml基本语法
```
#对象、Map（键值对）
person:
  age: 16
  tel: 123456
  name: lucius
#行内写法
#person: {name: qinjiang,age: 3}

#数组 List Set
pets:
  - cat
  - dog
  - pig
#行内写法
#pets: [cat,dog,pig]

#占位符引用其他属性的值，如果不存在可以设置默认值
person:
  age: ${random.int}、${random.long}、${random.int(10)}
  tel: 123456
  name: ${person.hello:hello}_旺财
#此时由于person.hello这个参数值不存在，因此默认值就是**hell0_旺财**
```

使用配置文件中的属性时，搭配使用到@ConfigurationProperties(prefix = "person")注解，@ConfigurationProperties作用：
将配置文件中配置的每一个属性的值，映射到这个组件中；告诉SpringBoot将本类中的所有属性和配置文件中相关的配置进行绑定参数 prefix = “person” : 将配置文件中的person下面的所有属性一一对应
只有这个组件是容器中的组件，才能使用容器提供的@ConfigurationProperties功能，因此还需要搭配@Component注解来将Bean注册到容器中

## 多环境配置
使用一个yaml文件就能够进行多环境配置，具体见demo

                                                           