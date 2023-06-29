package com.cuc.ctrip.api.controller;


import com.cuc.ctrip.api.config.R;
import com.cuc.ctrip.api.form.HelloSayGoodByeForm;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @GetMapping(value="/hello")
    public R hello()
    {
        return R.ok().put("mseeage","Hello");
    }


    @GetMapping(value="/say")//带参
    public R say(@RequestParam("name") String name,
                    @RequestParam("word") String word)
    {
        return R.ok().put("mseeage", name +"Say:" +word);
    }

    @PostMapping (value="/SayGoodBye")
    public R SayGoodBye(@RequestBody HelloSayGoodByeForm req)
    {
        return R.ok().put("message", " Say  GoodBye  to "+req.getName());
    }


}
