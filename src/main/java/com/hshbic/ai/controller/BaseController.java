package com.hshbic.ai.controller;

import com.hshbic.ai.common.base.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/live")
public class BaseController {

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public Result test(){
        return Result.success();
    }
}
