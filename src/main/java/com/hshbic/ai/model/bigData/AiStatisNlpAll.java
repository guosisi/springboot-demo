package com.hshbic.ai.model.bigData;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity(name = "ai_statis_nlp_all")
public class AiStatisNlpAll {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "logId")
    private Long logId;
    @Column(name ="userId")
    private String userId;
    @Column(name ="deviceId")
    private String deviceId;
    @Column(name ="query")
    private String query;
    @Column(name ="category")
    private String category;
    @Column(name ="domain")
    private String domain;
    @Column(name ="action")
    private String action;
    @Column(name ="param")
    private String param;
    @Column(name ="appId")
    private String appId;
    @Column(name ="nlpmode")
    private String nlpmode;
    @Column(name ="createTime")
    private Date createTime;
    @Column(name ="sn")
    private String sn;
    @Column(name ="actionTime")
    private Long actionTime;
    @Column(name ="retCode")
    private String retCode;
    @Column(name ="tarDeviceId")
    private String tarDeviceId;
    @Column(name="tarTypeid")
    private String tarTypeid;

}
