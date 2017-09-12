package so.sao.sharding.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Create by wuxingxing on 2017/8/30 11:17
 */
@Data
@Component
@ConfigurationProperties(prefix="spring.datasource.master")
public class MasterDataSource {
    private String url;
    private String username;
    private String password;
    private String driverClassName;
    private Long connectionTimeout;
    private Long idleTimeout;
    private Long maxLifetime;
    private Integer minimumIdle;
    private Integer maximumPoolSize;
}
