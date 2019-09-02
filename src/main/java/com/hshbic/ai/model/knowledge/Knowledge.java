package com.hshbic.ai.model.knowledge;

import lombok.Data;
import lombok.Getter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class Knowledge implements Serializable {

    private String id;

    private String question;

    private String answer;

    private String industryCategory;

    private String deviceType;

    private String questionType;

    private String questionSecondType; // 问题二级分类;

    private String enteringUser; //录入用户

    private String userType;

    private String reviewer; //编辑用户

    private int approvalStatus; //审核状态
    private int isOnline;  //是否上线  -1全部0 未上，1已上线
    private int testStatus;  //测试状态-1:全部 0:未通过 1:通过

    private String createTime;
    private String reviewerTime;
    private String testTime;
    private String onlineTime;


    private int esType; //0:审核页面  1:测试页面
}
