# bookManageSystem
a niubility springboot project

## 项目介绍

### 主要内容

实现一个书籍管理系统：

1. 主页：用于项目介绍、网站介绍、作者介绍等基本内容
2. 书单页：用于展示某一用户的书单
3. 添加页：用于在某用户的书单中添加书籍
4. 删除页：用于在某用户的书单中删除书籍
5. 错误页：当添加和删除出现错误时，跳转到该页

### 项目技术栈

本人蒟蒻，刚学SpringBoot，写了半天的SpringSecurity没写明白，放弃写注册登录页面了，采用前后端不分离的方式构建页面前后端逻辑，主要是用到了下面的这些技术

> 1. SpringBoot
> 2. Thymeleaf
> 3. Bootstrap
> 4. MyBatis-Plus

### 项目日志

### 2022-10-7

> 项目建立
>
> 创建SpringBoot后端
>
> 实现Pojo层：书单数据库
>
> 实现Mapper层：java与数据库的交互函数
>
> 实现Service层：（并实现相应Controller，使用MyBatis-Plus）
>
> 	1. 向书单中添加书籍
> 	1. 向书单中删除书籍
> 	1. 访问某一用户的一个书单并获取书单的所有信息

### 2022-10-8

>使用Thymeleaf模板引擎与Bootstrap响应式布局，实现前端页面：
>
>1. homePage页面
>2. readingList页面
>
>写了半个下午 + 一晚上的SpringSecurity，没写成，摆烂

### 2022-10-9

> 实现以下页面：
>
> 1. 添加书籍页面
> 2. 删除书籍页面
> 3. 错误页面
>
> 实现Controller以访问上述页面
>
> 上传Github并编写README.md

### 2022-10-10

> 更新ui内容

### 2022-10-11

> 添加配置
>
> 基本完成该项目
