package com.cuc.ctrip.api.controller;


import com.cuc.ctrip.api.config.R;
import com.cuc.ctrip.api.config.SQL;
import com.cuc.ctrip.api.form.EmployForm;
import com.cuc.ctrip.api.form.HelloSayGoodByeForm;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
