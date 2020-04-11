## springboot整合pagehelper

### 在整合了mybatis的基础上添加依赖
```xml
<!-- pagehelper -->
<dependency>
    <groupId>com.github.pagehelper</groupId>
    <artifactId>pagehelper-spring-boot-starter</artifactId>
    <version>1.2.12</version>
</dependency>
```

### 在dao层增加分页查询的方法
UserDao:

    Page<User> getUserList();
    
### 在service层
UserService:

    Page<User> getUserList();
    
UserServiceImpl:

    @Override
    public Page<User> getUserList() {
        return this.userDao.getUserList();
    }
    
### 在mapper配置文件中写sql语句
UserDao.xml:

    <select id="getUserList" resultMap="UserMap">
        select * from user
    </select>
    
### 在controller层中
UserController:

    @RequestMapping("/getUserList")
    public Page<User> getUserList(@RequestParam(defaultValue = "1")Integer pageNum, @RequestParam(defaultValue = "2")Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        Page<User>  userList= userService.getUserList();
        return userList;
    }

    @RequestMapping("/getUserList")
    public PageInfo<User> getUserList(@RequestParam(defaultValue = "1")Integer pageNum, @RequestParam(defaultValue = "2")Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        Page<User>  userList= userService.getUserList();
        PageInfo<User> pageInfo = new PageInfo<User>(userList);
        return pageInfo;
    }
    
pageInfo这种包含了数据库信息，一般使用选上面那种就可以了。

### 访问
http://localhost:8080/user/getUserList?pageNum=1&pageSize=3
这种是传参的，如果不加参数就是使用默认值
