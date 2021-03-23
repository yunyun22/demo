package com.example.demo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

/**
 * @author wang, jinqiao
 * @date 23/03/2021
 */
@Configuration
@MapperScan(basePackages = {"com.example.demo.mapper"},
        sqlSessionTemplateRef = "sqlSessionTemplate"
)
public class DataSourceConfiguration {

    @Bean(name = "dataSource")
    public DataSource setDataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL)
                .addScript("create-table.sql")
                .addScript("init-data.sql")
                .build();
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory setSqlSessionTemplate(@Qualifier("dataSource") DataSource dataSource) throws Exception {

        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResource("mapper/UserMapper.xml"));
        return bean.getObject();
    }


    @Bean(name = "sqlSessionTemplate")
    public SqlSessionTemplate setSqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean(name = "transactionManager")
    @Primary
    public DataSourceTransactionManager setTransactionManager(@Qualifier("dataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    @Primary
    public TransactionTemplate transactionTemplate(@Qualifier("transactionManager")DataSourceTransactionManager transactionManager) {
        return new TransactionTemplate(transactionManager);
    }
}
