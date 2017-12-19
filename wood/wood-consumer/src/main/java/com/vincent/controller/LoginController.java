package com.vincent.controller;

import com.vincent.controller.base.BaseController;
import com.vincent.req.LoginReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/person")
@Api("PersonController相关api")
public class LoginController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @ApiOperation("登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "data", required = true, value = "数据")
    })
    @GetMapping(value = "/login/{data}")
    public String login(@PathVariable String data) {
        logger.info(data);
        LoginReq req = gson.fromJson(data, LoginReq.class);
        return "Hello...." + req.getUsername() + "," + req.getPassword() + "," + req.getToken();
    }

}
