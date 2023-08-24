package com.coinswap.entity;

import com.coinswap.constant.CommonStatus;
import com.coinswap.constant.SysAdvertiseLocation;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Data
@Table
public class SysAdvertise {
    @Id
    private String serialNumber;

    @NotBlank(message = "name cannot be empty")
    private String name;

    @NotNull(message = "Ad slot cannot be empty")
    private SysAdvertiseLocation sysAdvertiseLocation;
    @NotBlank(message = "Ad language cannot be empty")
    private String lang;
    @NotBlank(message = "start time cannot be empty")
    private String startTime;
    @NotBlank(message = "end time cannot be empty")
    private String endTime;
    //image link url
    private String url;
    private String linkUrl;
    private String remark;
    @NotNull(message = "status cannot be empty\n")
    private CommonStatus status = CommonStatus.NORMAL;

    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+3")
    private Date date;
    @Column(columnDefinition = "TEXT")
    @Basic(fetch = FetchType.LAZY)
    private String content;
    private String author;
    private int sort = 0;



}
