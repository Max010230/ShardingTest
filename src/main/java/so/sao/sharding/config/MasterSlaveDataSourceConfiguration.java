package so.sao.sharding.config;

import com.dangdang.ddframe.rdb.sharding.api.MasterSlaveDataSourceFactory;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * Create by wuxingxing on 2017/8/21 15:54
 */
@Configuration
public class MasterSlaveDataSourceConfiguration {


    @Bean
    @ConfigurationProperties("spring.datasource.master")
    public DataSource masterDataSource(){
        return DataSourceBuilder.create()
                .type(HikariDataSource.class)
                .build();
    }
    @Bean
    @ConfigurationProperties("spring.datasource.slave1")
    public DataSource slave1DataSource(){
        return DataSourceBuilder.create()
                .type(HikariDataSource.class)
                .build();
    }
    @Bean
    @ConfigurationProperties("spring.datasource.slave2")
    public DataSource slave2DataSource(){
        return DataSourceBuilder.create()
                .type(HikariDataSource.class)
                .build();
    }

    @Bean
    @Primary
    @DependsOn({"masterDataSource","slave1DataSource","slave2DataSource"})
    public DataSource dataSource(DataSource masterDataSource,DataSource slave1DataSource,DataSource slave2DataSource) throws SQLException {

        HashMap<String, DataSource> slaveDataSourceMap = new HashMap<>();
        slaveDataSourceMap.put("slave1", slave1DataSource);
        slaveDataSourceMap.put("slave2", slave2DataSource);

        return MasterSlaveDataSourceFactory.createDataSource("masterSlaveDataSource",
                "master", masterDataSource, slaveDataSourceMap);

    }
}
