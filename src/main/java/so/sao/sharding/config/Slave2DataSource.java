package so.sao.sharding.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Create by wuxingxing on 2017/8/30 11:17
 */
@Data
@Component
@ConfigurationProperties(prefix="spring.datasource.slave2")
public class Slave2DataSource {
    private String url;
    private String username;
    private String password;
    private String driverClassName;
}
