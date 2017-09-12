package so.sao.sharding.domain;

import lombok.Data;

/**
 * Create by wuxingxing on 2017/9/7 15:26
 */
@Data
public class Advertisement {
    private Long id;
    private String name;
    private String url;
    private Integer position;
    private Long startTime;
    private Long endTime;
    private Long startTimeDaily;
    private Long endTimeDaily;
    private Integer duration;
    private Integer resourceType;
    private Long advertiserId;
    private String pixelSize;
    private Integer size;
    private Integer status;
    private Boolean isPackage;
    private Long packageId;
    private Float discount;
    private Integer level;
    private Integer quantity;
    private Long createdAt;
    private Long createdBy;
    private Long updatedAt;
    private Long updatedBy;
    private Boolean deleted;
}
