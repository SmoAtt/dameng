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
@RequestMapping("/Order/")
@RestController
public class OrderController {
    @GetMapping(value="/order")
    @ApiOperation("获取订单列表")
    public R GetList()
    {
        List alist =  SQL.GetResults("select Top 3 * from Sales.Orders");
        return R.ok().put("data",alist);
    }


    @GetMapping(value="/{orderid}")
    public R GetOrder(         @PathVariable("orderid") String  orderid          )
    {
        List alist=
                SQL.GetResults("select   * from  Sales.Orders  " +
                        "where  orderid= "+orderid);

        return  R.ok().put("data",alist);
    }

    @DeleteMapping(value="/{orderid}")
    public R DeleteOrder(         @PathVariable("orderid") String  orderid          )
    {
        List alist=
                SQL.GetResults("delete from  Sales.Orders  " +
                        "where  orderid= "+orderid);

        return  R.ok().put("message","删除成功").put("data",alist);
    }

    @PostMapping(value="/")
    public R AddEmploy(@RequestBody EmployForm req  )
    {
        List alist=
                SQL.GetResults("insert into test values(1,'"+req.getTitle()+"') ");

        return  R.ok().put("message","添加成功").put("data",alist);
    }

    @GetMapping(value="/hotel")
    @ApiOperation("获取酒店列表")
    public R GetHotelList()
    {
        List alist =  SQL.GetResults("select  * from dbo.hotel");
        return R.ok().put("data",alist);
    }

//    更新是否选择
    @PostMapping(value = "/changeselect")
    @ApiOperation("更新单项选择")
    public R UpdateEmployselect(@RequestParam("mySelected") String mySelected)
    {
        mySelected=mySelected.replace('\"','\'');
        String str="update dbo.hotel set 是否选择=0  "+
                "update dbo.hotel set 是否选择=1 where hotelname in"+"('"+mySelected+"')";
        System.out.println(str);
        SQL.GetResults( str);
        return  R.ok().put("message","更新单项选择成功");
    }

    //    更新是否复选
    @PostMapping(value = "/changecheck")
    @ApiOperation("更新复选选择")
    public R UpdateEmploycheck(@RequestParam("mycheckhotels") String mycheckhotels)
    {
        mycheckhotels="'"+mycheckhotels+"'";
        mycheckhotels=mycheckhotels.replace(",","\',\'");
        String str="update dbo.hotel set 是否复选=0  "+
                "update dbo.hotel set 是否复选=1 where hotelname in"+"("+mycheckhotels+")";
        System.out.println(str);
        SQL.GetResults( str);
        return  R.ok().put("message","更新复选选择成功");
    }

    @PostMapping(value="/InsertEmploy")
    public R InsertEmploy(@RequestParam Map<String,Object> hotel)
    {
        String str="update dbo.hotel set 是否选择=0";
        if(hotel.get("isselect")=="1"){
            SQL.GetResults(str);
        }
        List alist=
                SQL.GetResults("insert into dbo.Hotel values("+hotel.get("id").toString()+",'"+hotel.get("hotelname").toString()+"',"+hotel.get("isselect").toString()+","+hotel.get("ischeck").toString()+")");

        return  R.ok().put("message","添加成功").put("data",alist);
    }



    @RequestMapping(value="/Deletehotel/{hotelid}")
    public R Deletehotel(         @PathVariable String  hotelid          )
    {
        String str="delete from  dbo.Hotel  " +
                "where  hotelid="+hotelid;
        List alist= SQL.GetResults(str);

        return  R.ok().put("message","删除成功").put("data",alist);
    }

    @GetMapping(value="/Search",produces = "application/json;charset=UTF-8")
    public R Searchhotel(        @RequestParam("keyword")  String  keyword          )
    {
        if(keyword.matches("^[0-9]+$")){
            List alist= SQL.GetResults("select  * from  dbo.Hotel  " +
                    "where  hotelid="+keyword);
            return  R.ok().put("message","查询成功").put("data",alist);
        }else{
            String s="选择";
            String e="复选";
            if(keyword.equals(s)){
                System.out.println(2);
                List alist= SQL.GetResults("select  * from  dbo.Hotel  where  是否选择=1");
                return  R.ok().put("message","查询成功").put("data",alist);
            }else if(keyword.equals(e)) {
                System.out.println(3);
                List alist = SQL.GetResults("select  * from  dbo.Hotel where  是否复选=1");
                return R.ok().put("message", "查询成功").put("data", alist);
            }else{
                System.out.println(4);
                List alist = SQL.GetResults("select  * from  dbo.Hotel  " +
                        "where  hotelname like '%"+keyword+"%'");
                return R.ok().put("message", "查询成功").put("data", alist);
            }
        }
    }

    @PostMapping(value="/UdpatetEmploy")
    public R UdpatetEmploy(@RequestParam Map<String,Object> hotel)
    {
        String str="update dbo.hotel set 是否选择=0";
        String sql="update dbo.Hotel set hotelid="+hotel.get("id").toString()+", hotelname='"+hotel.get("hotelname").toString()+
                "', 是否选择="+hotel.get("isselect").toString()+", 是否复选="+hotel.get("ischeck").toString() +" where hotelid="+hotel.get("id").toString();
        if(hotel.get("isselect")=="1"){
            SQL.GetResults(str);
        }
        List alist= SQL.GetResults(sql);
        return  R.ok().put("message","修改成功").put("data",alist);
    }


}
