package so.sao.sharding.config;

import com.dangdang.ddframe.rdb.sharding.api.MasterSlaveDataSourceFactory;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * Create by wuxingxing on 2017/8/21 15:54
 */
@Configuration
public class XbDataSource {

    @Autowired
    private MasterDataSource masterDataSource;
    @Autowired
    private Slave1DataSource slave1DataSource;
    @Autowired
    private Slave2DataSource slave2DataSource;


    @Bean
    @Primary
    public DataSource shardingDataSource() throws SQLException {

        DataSource dataSource1 = createDataSource(masterDataSource.getDriverClassName(), masterDataSource.getUrl(),
                masterDataSource.getUsername(), masterDataSource.getPassword(),masterDataSource.getConnectionTimeout(),
                masterDataSource.getIdleTimeout(),masterDataSource.getMaxLifetime(),masterDataSource.getMinimumIdle(),
                masterDataSource.getMaximumPoolSize());

        DataSource dataSource2 = createDataSource(slave1DataSource.getDriverClassName(), slave1DataSource.getUrl(),
                slave1DataSource.getUsername(), slave1DataSource.getPassword(),slave1DataSource.getConnectionTimeout(),
                slave1DataSource.getIdleTimeout(),slave1DataSource.getMaxLifetime(),slave1DataSource.getMinimumIdle(),
                slave1DataSource.getMaximumPoolSize());

        DataSource dataSource3 = createDataSource(slave2DataSource.getDriverClassName(), slave2DataSource.getUrl(),
                slave2DataSource.getUsername(), slave2DataSource.getPassword(),slave2DataSource.getConnectionTimeout(),
                slave2DataSource.getIdleTimeout(),slave2DataSource.getMaxLifetime(),slave2DataSource.getMinimumIdle(),
                slave2DataSource.getMaximumPoolSize());

        HashMap<String, DataSource> slaveDataSourceMap = new HashMap<>();
        slaveDataSourceMap.put("slave1", dataSource2);
        slaveDataSourceMap.put("slave2", dataSource3);

        return MasterSlaveDataSourceFactory.createDataSource("masterSlaveDataSource",
                "master", dataSource1, slaveDataSourceMap);

    }

    private DataSource createDataSource(final String driverClassName, final String url,
                                        final String username,
                                        final String password,
                                        final Long ConnectionTimeout,
                                        final Long IdleTimeout,
                                        final Long MaxLifetime,
                                        final Integer MinimumIdle,
                                        final Integer MaximumPoolSize) {

        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setDriverClassName(driverClassName);
        hikariDataSource.setJdbcUrl(url);
        hikariDataSource.setUsername(username);
        hikariDataSource.setPassword(password);
        hikariDataSource.setConnectionTimeout(ConnectionTimeout);
        hikariDataSource.setIdleTimeout(IdleTimeout);
        hikariDataSource.setMaxLifetime(MaxLifetime);
        hikariDataSource.setMinimumIdle(MinimumIdle);
        hikariDataSource.setMaximumPoolSize(MaximumPoolSize);
        return hikariDataSource;
    }

}
