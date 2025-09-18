package com.sample.mybatis;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

/**
 * MybatisPlusGeneratorTests
 *
 * @author Aaric
 * @version 0.8.0-SNAPSHOT
 */
@Slf4j
public class MybatisPlusGeneratorTests {

    private static final String url = "jdbc:mysql://127.0.0.1:3306/component";

    private static final String username = "test";
    private static final String password = "test";

    @Test
    public void testCodeGenerate() throws Exception {

    }

    @Test
    public void testFastGenerate() throws Exception {
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> builder
                        .author("Aaric")
                        .outputDir(Paths.get(System.getProperty("user.dir")) + "/src/main/java")
                        .commentDate("yyyy-MM-dd")
                )
                .packageConfig(builder -> builder
                        .parent("com.sample.mp")
                        .entity("entity")
                        .mapper("mapper")
                        .service("service")
                        .serviceImpl("service.impl")
                        .xml("mapper.xml")
                )
                .strategyConfig(builder -> builder
                        .addInclude("test")
                        .entityBuilder()
                        .enableLombok()
                )
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}
