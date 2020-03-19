# online-face
一个基于Springboot和MybatisPlus以及Angular8的在线刷题系统

 最近一直想 \** ，想找个地方刷一刷\**题，可是却没发现一个很方便的能让我开心刷题的地方，
于是就自己想了这么一个系统 起初只是想做一个刷java\**题的系统，后面设计的时候发现可以做成一个通用的刷题系统
，只需要定义类型就可以了 。

swagger-ui地址：http://127.0.0.1:8080/face/swagger-ui.html

接口编写规则:

1、每一个接口均卸载对应模块的controller里面

2、每个接口需要加上返回类型的注解@AutoDoc(泛型的类型),可以方便给前端返回对应的实体类

3、接口里面需要添加下面这个方法

`    
@GetMapping("/getDoc")
    public Response getDoc(){
        return Response.ok();
    }
`
4、controller类上面需要加上注解

`
@EnableErrorCatch(模块名)
`

5、返回统一的类型是

`
Response<T>或者Response<PageData<T>>
`

6、工具方法写到CommonUtils里面

7、附件上传的工具在CommonUtils里面

8、常量需要定义在枚举里面

9、视图操作桥在VO目录里面编写对应的实体类

10、复杂条件查询请在QO目录下面编写对应的QO，可继承VO或entity

11、条件构造器请使用

` MyQueryWrapper<UserTrain> queryWrapper = MyQueryWrapper.query();`

未完待续。。。

具体的设计思路如下：
![刷题系统](https://github.com/xyz0101/online-face/blob/master/src/main/resources/static/%E5%88%B7%E9%A2%98%E7%B3%BB%E7%BB%9F.png)
