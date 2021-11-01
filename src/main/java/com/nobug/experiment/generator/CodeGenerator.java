package com.nobug.experiment.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * CodeGenerator
 *
 * @author liujiuxing@renrenche.com
 * @date 2020/9/16 18:36
 */
public class CodeGenerator {

    static final String  PATH_NAME = "finance-app";
    static final String  MODULE_NAME = "finance";
    static final String  DB_URL = ""; //TODO JDBCURL
    static final String  DB_DRIVER = "com.mysql.jdbc.Driver";
    static final String  DB_USERNAME = ""; //TODO username
    static final String  DB_PASSWORD = ""; //TODO password

    static final String  AUTHOR = "liyupeng";
    //
    static final String[] TABLE_NAME = new String[]{""};//TODO table name



    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir") + "/" + PATH_NAME;
        gc.setOutputDir(projectPath + "/src/test/java/generator/code");
        gc.setAuthor(AUTHOR);
        gc.setOpen(false);
        gc.setEnableCache(false);
        gc.setServiceImplName("%sDomain");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(DB_URL);
        // dsc.setSchemaName("public");
        dsc.setDriverName(DB_DRIVER);
        dsc.setUsername(DB_USERNAME);
        dsc.setPassword(DB_PASSWORD);
        mpg.setDataSource(dsc);



        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(MODULE_NAME);
        pc.setMapper("repository");
        pc.setService("service");
        pc.setServiceImpl("domain");
        // pc.setController("controller");
        pc.setXml("xml");
        //pc.setParent("com.renrenche.partner");
        mpg.setPackageInfo(pc);


        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + "/src/main/resources/mapper"
                        + "/" + tableInfo.getEntityName() + "Mapper" + ".xml";
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        //mpg.setTemplate(new TemplateConfig().setXml(null));

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass("com.baomidou.mybatisplus.activerecord.Model");
        strategy.setEntityLombokModel(true);
        strategy.entityTableFieldAnnotationEnable(true);
        strategy.setRestControllerStyle(true);
        //strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");
        strategy.setSuperServiceImplClass(null);
        strategy.setSuperServiceClass(null);
        strategy.setInclude(TABLE_NAME);
        //strategy.setSuperEntityColumns("id");
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(new String[]{"p_"}); //TODO表前缀
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();

        System.out.println("\n-- Done.");
    }
}
