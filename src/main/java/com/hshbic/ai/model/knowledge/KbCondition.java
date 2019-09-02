package com.hshbic.ai.model.knowledge;

import com.alibaba.fastjson.JSONObject;
import com.hshbic.ai.common.base.Page;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class KbCondition extends Page implements Serializable {

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

    private int approvalStatus; //审核状态 -1:全部 0:待审核  1:审核通过 2:审核不通过

    private String reviewInfo; //审核批注

    private int isOnline;  //是否上线  -1全部0 未上，1已上线

    private int testStatus;  //测试状态-1:全部 0:未通过 1:通过

    private int isSync;  //是否同步  -1:全部 0:未同步 1:同步

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    @Getter private List<Date> createTime = new ArrayList<Date>();
    @Getter private JSONObject jsonCreateTime =new JSONObject();


    @Getter private List<Date> reviewerTime = new ArrayList<Date>();
    @Getter private JSONObject jsonReviewerTime =new JSONObject();


    @Getter private List<Date> testTime = new ArrayList<Date>();
    @Getter private JSONObject jsonTestTime =new JSONObject();

    @Getter private List<Date> onlineTime = new ArrayList<Date>();
    @Getter private JSONObject jsonOnlineTime =new JSONObject();

    private int esType; //0:审核页面  1:测试页面

    private List<String> ids; // id 列表
    private List<String> reIds; // 重新审核id 列表


    KbCondition(){ super();}


    public void setCreateTime(List<Date> createTime) {
        this.createTime = createTime;
        // if(StringUtils.isNoneBlank(createTime.get(0))&& StringUtils.isNoneBlank(createTime.get(1))){
        jsonReviewerTime.put("startTime", sdf.format(createTime.get(0)));
        jsonReviewerTime.put("endTime", sdf.format(createTime.get(1)));
        // }

    }

    public void setReviewerTime(List<Date> reviewerTime) {
        this.reviewerTime = reviewerTime;
       // if(StringUtils.isNoneBlank(reviewerTime.get(0))&& StringUtils.isNoneBlank(reviewerTime.get(1))){
            jsonReviewerTime.put("startTime", sdf.format(reviewerTime.get(0)));
            jsonReviewerTime.put("endTime", sdf.format(reviewerTime.get(1)));
       // }

    }


    public void setTestTime(List<Date> testTime) {
        this.testTime = testTime;
//        if(StringUtils.isNoneBlank(testTime.get(0))&& StringUtils.isNoneBlank(testTime.get(1))){
            jsonTestTime.put("startTime", sdf.format(testTime.get(0)));
            jsonTestTime.put("endTime", sdf.format(testTime.get(1)));
//        }
    }


    public void setOnlineTime(List<Date> onlineTime) {
        this.onlineTime = onlineTime;
       // if(StringUtils.isNoneBlank(onlineTime.get(0))&& StringUtils.isNoneBlank(onlineTime.get(1))){
            jsonOnlineTime.put("startTime", sdf.format(onlineTime.get(0)));
            jsonOnlineTime.put("endTime", sdf.format(onlineTime.get(1)));
       // }
    }


    
    
}
