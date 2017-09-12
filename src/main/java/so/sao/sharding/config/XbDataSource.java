package so.sao.sharding.config;

import com.dangdang.ddframe.rdb.sharding.api.MasterSlaveDataSourceFactory;
import com.dangdang.ddframe.rdb.sharding.api.ShardingDataSourceFactory;
import com.dangdang.ddframe.rdb.sharding.api.rule.DataSourceRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.ShardingRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.TableRule;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Create by wuxingxing on 2017/8/21 15:54
 */
@Configuration
public class XbDataSource {
//    @Autowired
//    DataSource dataSource;

    @Autowired
    private MasterDataSource masterDataSource;
    @Autowired
    private Slave1DataSource slave1DataSource;
    @Autowired
    private Slave2DataSource slave2DataSource;


    @Bean
    @Primary
    public DataSource shardingDataSource() throws SQLException {



        DataSourceRule dataSourceRule = new DataSourceRule(createDataSourceMap());

        List<TableRule> tableRuleList = new ArrayList<>();
        //tb_p逻辑表名，pList实际所有的分表
        tableRuleList.add(new TableRule.TableRuleBuilder("t_order_0")
                .actualTables(Lists.newArrayList("t_order_0"))
                .dataSourceRule(dataSourceRule).build());
        tableRuleList.add(new TableRule.TableRuleBuilder("t_order_item_0")
                .actualTables(Lists.newArrayList("t_order_item_0"))
                .dataSourceRule(dataSourceRule).build());
        ShardingRule shardingRule = ShardingRule.builder()
                .dataSourceRule(dataSourceRule)
                .tableRules(tableRuleList)
                .build();
        return ShardingDataSourceFactory.createDataSource(shardingRule);
    }

    private DataSource createDataSource(final String driverClassName, final String url, final String username, final String password) {

        return DataSourceBuilder.create().driverClassName(driverClassName).url(url).username(username).password(password).build();

    }

    private HashMap<String, DataSource> createDataSourceMap() throws SQLException {
        DataSource dataSource1 = createDataSource(masterDataSource.getDriverClassName(), masterDataSource.getUrl(),
                masterDataSource.getUsername(), masterDataSource.getPassword());

        DataSource dataSource2 = createDataSource(slave1DataSource.getDriverClassName(), slave1DataSource.getUrl(),
                slave1DataSource.getUsername(), slave1DataSource.getPassword());

        DataSource dataSource3 = createDataSource(slave2DataSource.getDriverClassName(), slave2DataSource.getUrl(),
                slave2DataSource.getUsername(), slave2DataSource.getPassword());
        HashMap<String, DataSource> map = new HashMap<>();
        HashMap<String, DataSource> slaveDataSourceMap = new HashMap<>();
        slaveDataSourceMap.put("slave1", dataSource2);
        slaveDataSourceMap.put("slave2", dataSource3);
        DataSource masterSlaveDs0 = MasterSlaveDataSourceFactory.createDataSource("masterSlaveDataSource",
                "master", dataSource1, slaveDataSourceMap);

        map.put("dataSource", masterSlaveDs0);
        return map;
    }

}
