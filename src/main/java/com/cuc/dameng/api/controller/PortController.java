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
    @GetMapping(value="/ALLPORTSTARTCOUNT")
    @ApiOperation("各港口作业开始计数表")
    public R GetALLPORTSTARTCOUNT()
    {
        List alist =  SQL.GetResults("select  * from JES.ALLPORTSTARTCOUNT");
        return R.ok().put("data",alist);
    }

    @GetMapping(value="/ALLPORTSTOPCOUNT")
    @ApiOperation("各港口作业结束计数表")
    public R GetALLPORTSTOPCOUNT()
    {
        List alist =  SQL.GetResults("select  * from JES.ALLPORTSTOPCOUNT");
        return R.ok().put("data",alist);
    }

    @GetMapping(value="/ALLPORTNUMB")
    @ApiOperation("各港口吞吐量")
    public R GetALLPORTNUMB()
    {
        List alist =  SQL.GetResults("select  * from JES.ALLPORTNUMB");
        return R.ok().put("data",alist);
    }

    @GetMapping(value="/BOXSIZELOGISTICSDYNAMICS")
    @ApiOperation("各港口集装箱尺寸吞吐量")
    public R GetBOXSIZELOGISTICSDYNAMICS()
    {
        List alist =  SQL.GetResults("select  * from JES.BOXSIZELOGISTICSDYNAMICS");
        return R.ok().put("data",alist);
    }

    @GetMapping(value="/GOODS_TIMEDIFF")
    @ApiOperation("各商品货运数据")
    public R GetGOODS_TIMEDIFF()
    {
        List alist =  SQL.GetResults("select  * from JES.GOODS_TIMEDIFF");
        return R.ok().put("data",alist);
    }

    @GetMapping(value="/GOODS_TIMEDIFF_ONE")
    @ApiOperation("各商品货运数据")
    public R GetGOODS_TIMEDIFF_ONE()
    {
        List alist =  SQL.GetResults("select  * from JES.GOODS_TIMEDIFF_ONE");
        return R.ok().put("data",alist);
    }

    @GetMapping(value="/INCOMINGSHIPS_TAICANG_DAY_AUGUST")
    @ApiOperation("太仓港每日货运数据")
    public R GetINCOMINGSHIPS_TAICANG_DAY_AUGUST()
    {
        List alist =  SQL.GetResults("select  * from JES.INCOMINGSHIPS_TAICANG_DAY_AUGUST");
        return R.ok().put("data",alist);
    }

    @GetMapping(value="/JIDU21_SHIPCOMPANYNUMB")
    @ApiOperation("21年各季度货运公司数据")
    public R GetJIDU21_SHIPCOMPANYNUMB()
    {
        List alist =  SQL.GetResults("select  * from JES.JIDU21_SHIPCOMPANYNUMB");
        return R.ok().put("data",alist);
    }

    @GetMapping(value="/JIDU22_SHIPCOMPANYNUMB")
    @ApiOperation("22年各季度货运公司数据")
    public R GetJIDU22_SHIPCOMPANYNUMB()
    {
        List alist =  SQL.GetResults("select  * from JES.JIDU22_SHIPCOMPANYNUMB");
        return R.ok().put("data",alist);
    }

    @GetMapping(value="/MONTH_ALLGOODSNAMEWEIGHT")
    @ApiOperation("各港口商品货运详情")
    public R GetMONTH_ALLGOODSNAMEWEIGHT()
    {
        List alist =  SQL.GetResults("select  * from JES.MONTH_ALLGOODSNAMEWEIGHT");
        return R.ok().put("data",alist);
    }

    @GetMapping(value="/MONTH_ALLSHIPCOMPANYNUMB")
    @ApiOperation("各船运公司于各港口的货运数据")
    public R GetMONTH_ALLSHIPCOMPANYNUMB()
    {
        List alist =  SQL.GetResults("select  * from JES.MONTH_ALLSHIPCOMPANYNUMB");
        return R.ok().put("data",alist);
    }

    @GetMapping(value="/PIV_GOODNAME")
    @ApiOperation("各港口的商品货运详情")
    public R GetPIV_GOODNAME()
    {
        List alist =  SQL.GetResults("select  * from JES.PIV_GOODNAME");
        return R.ok().put("data",alist);
    }


}
