package com.jenkin.onlineface;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.springframework.util.StringUtils;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Generator {
   static  List<TableFill> tableFillList = new ArrayList<>();

static {
    // 自定义需要填充的字段 数据库中的字段

    tableFillList.add(new TableFill("last_update_date",FieldFill.INSERT_UPDATE));
    tableFillList.add(new TableFill("last_update_by", FieldFill.INSERT_UPDATE));
    tableFillList.add(new TableFill("create_by", FieldFill.INSERT));
    tableFillList.add(new TableFill("creation_date", FieldFill.INSERT));


}


    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(("请输入" + tip + "："));
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (!StringUtils.isEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {


        String projectPath = System.getProperty("user.dir");


        //1、全局配置
        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(true)//开启AR模式
                .setAuthor("jenkin")//设置作者
                //生成路径(一般都是生成在此项目的src/main/java下面)
                .setOutputDir(projectPath + "/src/main/java")
                .setOpen(false)//不要自动打开目录
                .setFileOverride(true)//第二次生成会把第一次生成的覆盖掉
                .setIdType(IdType.AUTO)//主键策略
                .setSwagger2(true)
                .setServiceName("%sService")//生成的service接口名字首字母是否为I，这样设置就没有I
                .setBaseResultMap(true)//生成resultMap
                .setBaseColumnList(true);//在xml中生成基础列
        //2、数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)//数据库类型
                .setUrl("jdbc:mysql://119.29.175.198:1995/face_online?useUnicode=true&useSSL=false&characterEncoding=utf8")
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUsername("jenkin")
                .setPassword("ZhoujinJenkin@1995");
        //3、策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true)//开启全局大写命名
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setNaming(NamingStrategy.underline_to_camel)//下划线到驼峰的命名方式
                .setTablePrefix("face_")//表名前缀
                .setEntityLombokModel(true)//使用lombok
                .setRestControllerStyle(true)
                .setVersionFieldName("version_number")
                .setTableFillList(tableFillList)
                .setControllerMappingHyphenStyle(true)
                .setRestControllerStyle(true)
                .setInclude(scanner("表名，多个英文逗号分割").split(","));//逆向工程使用的表
        //4、包名策略配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.jenkin.onlineface")//设置包名的parent
                .setMapper("mapper")
                .setModuleName(scanner("模块名"))
                .setService("service")
                .setController("controller")
                .setEntity("entity")
                .setXml("mapper");//设置xml文件的目录
        //5、整合配置
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig);
        //6、执行
        autoGenerator.execute();
    }

}

