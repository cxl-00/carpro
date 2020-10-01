package com.cxl.carpro.mysqlgenerator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.FileType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author chenxiaoling
 * 配置详情参见
 * https://mp.baomidou.com/config/generator-config.html
 */
public class MysqlCodeGenerator {

    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");

    }

    /**
     * 表名
     */
    private static final String TABLE_NAMES = "rental_info";
    // 项目目录相对路径
    /*private static final String projectPath = System.getProperty("user.dir");*/
    //
    /**
     * 项目目录绝对路径
     */
    private static final String PROJECT_PATH = "/Users/chenxiaoling/workspace/my/carpro";

    public static void main(String[] args) {
        //1、全局配置
        GlobalConfig globalConfig = createGlobalConfig();
        //2、数据源配置
        DataSourceConfig dataSourceConfig = createDataSourceConfig();
        //3、包名策略配置
        PackageConfig packageConfig = createPackageConfig();
        //4、策略配置
        StrategyConfig strategyConfig = createStrategyConfig();
        //5、配置模板
        TemplateConfig templateConfig = createTemplateConfig();
        //6、自定义配置
        InjectionConfig injectionConfig = createInjectionConfig();
        //7、整合配置
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(globalConfig)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig)
                .setTemplateEngine(new FreemarkerTemplateEngine());
        //8、执行
        autoGenerator.execute();
    }

    private static InjectionConfig createInjectionConfig() {
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return PROJECT_PATH + "/src/main/resources/mapper/" + tableInfo.getXmlName() + StringPool.DOT_XML;
//                return projectPath + "/src/main/resources/mapper/" + packageConfig.getModuleName() + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        injectionConfig.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录，自定义目录用");
                if (fileType == FileType.MAPPER) {
                    // 已经生成 mapper 文件判断存在，不想重新生成返回 false
                    return !new File(filePath).exists();
                }
                // 允许生成模板文件
                return true;
            }
        });
        injectionConfig.setFileOutConfigList(focList);
        return injectionConfig;
    }

    private static TemplateConfig createTemplateConfig() {
        TemplateConfig templateConfig = new TemplateConfig();
        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        templateConfig.setEntity("templates/entity2.java")
                .setService("")
                .setServiceImpl("")
                .setMapper("")
                .setXml("")
                .setController("");
        return templateConfig;
    }

    private static StrategyConfig createStrategyConfig() {
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                // 开启全局大写命名
                .setCapitalMode(true)
                // 是否跳过视图
                .setSkipView(true)
                // 数据库表映射到实体的命名策略:下划线到驼峰的命名方式
                .setNaming(NamingStrategy.underline_to_camel)
                // 数据库表字段映射到实体的命名策略, 未指定按照 naming 执行
                .setColumnNaming(NamingStrategy.underline_to_camel)
                // 表名前缀
//                .setTablePrefix("tb_")
                // 字段前缀
//                .setFieldPrefix("")
                // 自定义继承的Entity类全称，带包名
//                .setSuperEntityClass("")
                // 自定义基础的Entity类，公共字段
//                .setSuperEntityColumns("id")
                // 自定义继承的Mapper类全称，带包名
//                .setSuperMapperClass("")
                // 自定义继承的Service类全称，带包名
//                .setSuperServiceClass("")
                // 自定义继承的ServiceImpl类全称，带包名
//                .setSuperServiceImplClass("")
                // 自定义继承的Controller类全称，带包名
//                .setSuperControllerClass("")
                // 实体类是否为链式模型  @Accessors(chain = true)
                .setChainModel(true)
                // 实体是否生成字段常量
                .setEntityColumnConstant(true)
                // 使用lombok
                .setEntityLombokModel(true)
                // Boolean类型字段是否移除is前缀
                .setEntityBooleanColumnRemoveIsPrefix(false)
                // 生成实体时，是否生成字段注解
                .setEntityTableFieldAnnotationEnable(true)
                // 生成 @RestController 控制器
                .setRestControllerStyle(true)
                // 驼峰转连字符
                .setControllerMappingHyphenStyle(true)
                // 逻辑删除属性名称
                .setLogicDeleteFieldName("deleted")
                // 表填充字段
                /*.setTableFillList()*/
                // 激活进行sql模糊表名匹配,关闭之后likeTable与notLikeTable将失效，include和exclude将使用内存过滤
                .setEnableSqlFilter(true)
                // 模糊匹配的表名，多个表名用逗号分割
                .setInclude(TABLE_NAMES)
                /*.setInclude(scanner("表名，多个使用英文逗号分割").split(","))*/
                // 需要排除的模糊匹配的表名，多个表名用逗号分割
                .setExclude();
        return strategyConfig;
    }

    private static PackageConfig createPackageConfig() {
        PackageConfig packageConfig = new PackageConfig();
        packageConfig
                // 设置包名的parent
                .setParent("com.cxl.carpro")
                /*.setModuleName(scanner("父包模块名"))*/
                .setEntity("dao.model")
                .setController("controller")
                .setService("dao.repository")
                .setServiceImpl("dao.repository.impl")
                .setMapper("dao.mapper")
                // 设置xml文件的目录
                .setXml("dao.mapper");
        return packageConfig;
    }

    private static DataSourceConfig createDataSourceConfig() {

        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig
                // 数据库类型
                .setDbType(DbType.MYSQL)
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUrl("jdbc:mysql://localhost:3306/carpro?useUnicode=true&useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=utf8")
                .setUsername("root")
                .setPassword("San5525.")
                // 数据库 schema name
                .setSchemaName("carpro");
        return dataSourceConfig;
    }

    private static GlobalConfig createGlobalConfig() {
        //1、全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig
                // 生成文件的输出目录
                .setOutputDir(PROJECT_PATH + "/src/main/java")
                // 生成注释时的作者
                .setAuthor("chenxiaoling")
                // 生成后是否打开资源管理器
                .setOpen(false)
                // 重新生成时文件是否覆盖
                .setFileOverride(true)
                // 主键策略
                .setIdType(IdType.AUTO)
                // 定义生成的实体类中日期类型
//                .setDateType(DateType.ONLY_DATE)
                // 开启 ActiveRecord 模式
                .setActiveRecord(true)
                // 生成 resultMap
                .setBaseResultMap(true)
                // 在xml中生成基础列
                .setBaseColumnList(true)
                // 实体命名方式
                .setEntityName("%sDO")
                // controller命名方式
                .setControllerName("%sController")
                // 生成的service名称
                .setServiceName("%sRepository")
                // service impl命名方式
                .setServiceImplName("%sRepositoryImpl")
                // mapper命名方式
                .setMapperName("%sMapper");
        return globalConfig;
    }

}
