package com.hshbic.ai.model.bigData;

import lombok.Data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Data
@Entity(name="ai_statis_all")
public class AiStatisDetailAll {

	/**
	 * 主键
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * 用户id
	 */
	@Column(name="userId")
	private String userId;
	
	/**
	 * 设备id
	 */
	@Column(name="deviceId")
	private String deviceId;
	
	/**
	 * 会话唯一标识
	 */
	@Column(name="sessionId")
	private String sessionId;
	
	/**
	 * 各app的标识
	 */
	@Column(name="appId")
	private String appId;
	
	/**
	 * 请求时间
	 */
	@Column(name="createTime")
	private Date createTime;
	
	/**
	 * 请求耗时,单位毫秒
	 */
	@Column(name="actionTime")
	private Long actionTime;
	
	/**
	 * 响应错误码
	 */
	@Column(name="retCode")
	private String retCode;
	
	/**
	 * 状态,0-失败,1-成功
	 */
	@Column(name="status")
	private Byte status;
	
	/**
	 * 请求类型,分为asr:语音,nlp:语义,third:第三方音箱
	 */
	@Column(name="type")
	private String type;
	
	/**
	 * 云端流水
	 */
	@Column(name="sn")
	private String sn;
	
	/**
	 * 云端日志id
	 */
	@Column(name="logId")
	private Long logId;
	
	
	/**
	 * 用户clientId，不持久化
	 */
	@Transient
	private String clientId;
	/**
	 * 用户token，不持久化
	 */
	@Transient
	private String token;


}
