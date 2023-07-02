package com.cuc.dameng.api.controller;


import com.cuc.dameng.api.config.R;
import com.cuc.dameng.api.config.SQL;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin   //开启支持跨域请求
@RequestMapping("/Dameng/")
@RestController
public class PortController {
    @GetMapping(value="/list")
    @ApiOperation("获取列表")
    public R GetList()
    {
        List alist =  SQL.GetResults("select  * from JES.ALLPORTSTOPCOUNT");
        return R.ok().put("data",alist);
    }
}
