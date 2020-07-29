# MyBatis

## 1、简介

### 1.1 什么是Mybatis



![在这里插入图片描述](assets/2020062316463790.png)

- **MyBatis 是一款优秀的持久层框架;**
- 它支持自定义 SQL、存储过程以及高级映射。MyBatis 免除了几乎所有的 JDBC 代码以及设置参数和获取结果集的工作。MyBatis 可以通过简单的 XML 或注解来配置和映射原始类型、接口和 Java POJO（Plain Old Java Objects，普通老式 Java 对象）为数据库中的记录。

### 1.2 持久化

数据持久化

- 持久化就是将程序的数据在持久状态和瞬时状态转化的过程
- 内存：**断电即失**
- 数据库（Jdbc）,io文件持久化。

**为什么要持久化？**

- 有一些对象，不能让他丢掉
- 内存太贵

### 1.3 持久层

Dao层、Service层、Controller层

- 完成持久化工作的代码块
- 层界限十分明显

### 1.4 为什么需要MyBatis

- 帮助程序员将数据存入到数据库中
- 方便
- 传统的JDBC代码太复杂了，简化，框架，自动化
- 不用MyBatis也可以，技术没有高低之分
- 优点：
  - 简单易学
  - 灵活
  - sql和代码的分离，提高了可维护性。
  - 提供映射标签，支持对象与数据库的orm字段关系映射
  - 提供对象关系映射标签，支持对象关系组建维护
  - 提供xml标签，支持编写动态sql

## 2、第一个Mybatis程序

思路：搭建环境 --> 导入MyBatis --> 编写代码 --> 测试

### 2.1 搭建环境

新建项目

1. 创建一个普通的maven项目
2. 删除src目录 （就可以把此工程当做父工程了，然后创建子工程）
3. 导入maven依赖

```xml
    <dependencies>
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.5</version>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.20</version>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.12</version>
        </dependency>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13</version>
            <scope>helloTest</scope>
        </dependency>
    </dependencies>

```

4. 创建一个Module

### 2.2 创建一个模块

- 编写mybatis的核心配置文件

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<!--configuration核心配置文件-->
<configuration>
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/mybatis?userSSL=true&amp;useUnicode=true&amp;characterEncoding=UTF-8&amp;serverTimezone=UTC"/>
                <property name="username" value="root"/>
                <property name="password" value="root"/>
            </dataSource>
        </environment>
    </environments>
</configuration>
```

- 编写mybatis工具类

```java
  //sqlSessionFactory --> sqlSession
  public class MybatisUtils {
  
      static SqlSessionFactory sqlSessionFactory = null;
  
      static {
          try {
              //使用Mybatis第一步 ：获取sqlSessionFactory对象
              String resource = "mybatis-config.xml";
              InputStream inputStream = Resources.getResourceAsStream(resource);
              sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
  
      //既然有了 SqlSessionFactory，顾名思义，我们可以从中获得 SqlSession 的实例.
      // SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。
      public static SqlSession getSqlSession(){
          return sqlSessionFactory.openSession();
      }
  }
```

  ### 2.3 编写代码

  - 实体类

  - Dao接口

    ```java
    public interface UserDao {
        public List<User> getUserList();
    }
    123
    ```

- 接口实现类 （由原来的UserDaoImpl转变为一个Mapper配置文件）

  ```xml
  <?xml version="1.0" encoding="UTF-8" ?>
  <!DOCTYPE mapper
          PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
          "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
  <!--namespace绑定一个对应的mapper接口-->
  <mapper namespace="dao.UserDao">
  
      <!--id方法名-->
      <select id="getUserList" resultType="pojo.User">
          SELECT * FROM USER
      </select>
  
  </mapper>
  ```

- 测试

  **注意点：**

  org.apache.ibatis.binding.BindingException: Type interface com.kuang.dao.UserDao is not known to the MapperRegistry.

  **MapperRegistry是什么?**

  核心配置文件中注册mappers

  ```xml
      <!--每一个mapper.xml都需要注册-->
      <mappers>
          <mapper resource="dao/UserMapper.xml"/>
      </mappers>
  ```

  - junit测试

    ```java
        @Test
        public void test(){
    
            //1.获取SqlSession对象
            SqlSession sqlSession = MybatisUtils.getSqlSession();
            //2.执行SQL
            // 方式一：getMapper
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            List<User> userList = userDao.getUserList();
            for (User user : userList) {
                System.out.println(user);
            }
    
            //关闭sqlSession
            sqlSession.close();
        }
    12345678910111213141516
    ```