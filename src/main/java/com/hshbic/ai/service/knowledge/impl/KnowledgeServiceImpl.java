package com.hshbic.ai.service.knowledge.impl;

import com.github.pagehelper.PageInfo;
import com.hshbic.ai.common.base.Result;
import com.hshbic.ai.common.base.SysConstant;
import com.hshbic.ai.common.config.EsHandlerConfiguration;
import com.hshbic.ai.common.utils.DateUtil;
import com.hshbic.ai.enums.knowledge.KnowledgeResCode;
import com.hshbic.ai.model.knowledge.KbCondition;
import com.hshbic.ai.model.knowledge.Knowledge;
import com.hshbic.ai.service.knowledge.KnowledgeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("knowledgeService")
public class KnowledgeServiceImpl implements KnowledgeService {

    private static final Logger logger = LoggerFactory.getLogger(KnowledgeServiceImpl.class);

    @Autowired
    private EsHandlerConfiguration esHandlerConfiguration;

    @Value("${path.downloadPath}")
    private String downloadPath ;
    @Value("${path.uploadPath}")
    private String uploadPath ;


    @Override
    public PageInfo<Knowledge> list(KbCondition condition) {
        return null;
    }

    @Override
    public String export(KbCondition condition) {
        return null;
    }
}
