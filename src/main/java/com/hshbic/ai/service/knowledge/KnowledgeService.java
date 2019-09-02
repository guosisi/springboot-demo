package com.hshbic.ai.service.knowledge;

import com.github.pagehelper.PageInfo;
import com.hshbic.ai.common.base.Result;
import com.hshbic.ai.model.knowledge.KbCondition;
import com.hshbic.ai.model.knowledge.Knowledge;

import java.util.List;

public interface KnowledgeService {

    /**
     * 查询
     * @param condition
     * @return
     */
    public PageInfo<Knowledge>  list(KbCondition condition);

    /**
     * 导出
     * @param condition
     */
    public String export(KbCondition condition);




}
