package com.hshbic.ai.controller.knowledge;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hshbic.ai.common.base.Result;
import com.hshbic.ai.model.knowledge.KbCondition;
import com.hshbic.ai.model.knowledge.Knowledge;
import com.hshbic.ai.service.knowledge.KnowledgeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/knowledge")
public class KnowledgeController {


    private Logger logger =  LoggerFactory.getLogger(this.getClass());

    @Autowired(required = false)
    private KnowledgeService knowledgeService;

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public Map<String,Object> list(@RequestBody KbCondition condition){
        Map<String,Object> map=new HashMap<String,Object>();
        PageHelper.startPage(condition.getPageNo(),condition.getPageSize());
        PageInfo<Knowledge> pageInfo = knowledgeService.list(condition);
        map.put("pageInfo",pageInfo);
        map.put("code", Result.successCode);
        return map;
    }

    @RequestMapping(value = "/getById",method = RequestMethod.GET)
    public Object getById(@RequestParam("id") String id){
        Map<String,Object> map=new HashMap<String,Object>();
//        Knowledge model = knowledgeService.getOne(id);
//        map.put("model",model);
        map.put("code", Result.successCode);
        return map;
    }
}
