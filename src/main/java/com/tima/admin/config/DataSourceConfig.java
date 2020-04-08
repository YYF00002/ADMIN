package com.tima.admin.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.baomidou.mybatisplus.MybatisConfiguration;
import com.baomidou.mybatisplus.entity.GlobalConfiguration;
import com.baomidou.mybatisplus.mapper.LogicSqlInjector;
import com.baomidou.mybatisplus.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : 披荆斩棘
 * @date : 2017/9/6
 */
@Configuration
public class DataSourceConfig {

    /**
     * 动态数据源配置
     *
     * @return
     */
    @Bean
    public DynamicMultipleDataSource multipleDataSource(@Qualifier(GlobalConstant.ADMIN_DATA_SOURCE_KEY) DataSource dataSourceAdmin
    ) {
        DynamicMultipleDataSource dynamicMultipleDataSource = new DynamicMultipleDataSource();
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(GlobalConstant.ADMIN_DATA_SOURCE_KEY, dataSourceAdmin);
        dynamicMultipleDataSource.setTargetDataSources(targetDataSources);
        dynamicMultipleDataSource.setDefaultTargetDataSource(dataSourceAdmin);
        return dynamicMultipleDataSource;
    }

    @Primary
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid.admin")
    public DataSource dataSourceAdmin() {
        return DruidDataSourceBuilder.create().build();
    }

   


 /*   @Bean
    public SqlSessionFactory sqlSessionFactory ( DynamicMultipleDataSource dynamicMultipleDataSource ) throws
                                                                                                       Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource( dynamicMultipleDataSource );
        return sqlSessionFactoryBean.getObject();
    }*/

    @Bean
    public DataSourceTransactionManager transactionManager(DynamicMultipleDataSource dynamicMultipleDataSource) throws
            Exception {
        return new DataSourceTransactionManager(dynamicMultipleDataSource);
    }

    //    @Bean
//    @Primary
//    public MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean ( DynamicMultipleDataSource dynamicMultipleDataSource ) {
//        MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource( dynamicMultipleDataSource );
//        return sqlSessionFactoryBean;
//    }
    // @Bean("mybatisSqlSession")
    @Bean
    @Primary
    public SqlSessionFactory sqlSessionFactory(DynamicMultipleDataSource dynamicMultipleDataSource, ResourceLoader resourceLoader, GlobalConfiguration globalConfiguration) throws Exception {
        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dynamicMultipleDataSource);
//        sqlSessionFactory.setConfigLocation(resourceLoader.getResource("classpath:mybatis-config.xml"));
//        sqlSessionFactory.setMapperLocations(mapperLocations);
        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/**.xml"));
        sqlSessionFactory.setTypeAliasesPackage("com.tima.admin.entity");
        MybatisConfiguration configuration = new MybatisConfiguration();
//        configuration.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
//        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setJdbcTypeForNull(JdbcType.NULL);

        configuration.setMapUnderscoreToCamelCase(true);
        sqlSessionFactory.setConfiguration(configuration);
        PaginationInterceptor pagination = new PaginationInterceptor();
        pagination.setLocalPage(true);
        OptimisticLockerInterceptor optLock = new OptimisticLockerInterceptor();
        sqlSessionFactory.setPlugins(new Interceptor[]{
                pagination,
                optLock,
                new PerformanceInterceptor()
        });
        globalConfiguration.setMetaObjectHandler(new MyMetaObjectHandler());
        sqlSessionFactory.setGlobalConfig(globalConfiguration);
        return sqlSessionFactory.getObject();
    }

    @Bean
    public GlobalConfiguration globalConfiguration() {
        GlobalConfiguration conf = new GlobalConfiguration(new LogicSqlInjector());
        conf.setLogicDeleteValue("1");
        conf.setLogicNotDeleteValue("0");
        conf.setDbColumnUnderline(true);
        conf.setRefresh(true);
        conf.setFieldStrategy(2);
        conf.setIdType(0);
        conf.setDbType("mysql");
        return conf;
    }


}



