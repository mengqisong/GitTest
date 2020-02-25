package io.mqs.jcartadministrationback.controller;

import io.mqs.jcartadministrationback.dto.in.*;
import io.mqs.jcartadministrationback.dto.out.AdministratorGetProfileOutDTO;
import io.mqs.jcartadministrationback.dto.out.AdministratorListOutDTO;
import io.mqs.jcartadministrationback.dto.out.AdministratorShowOutDTO;
import io.mqs.jcartadministrationback.dto.out.PageOutDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/administrator")
public class AdministratorController {

    //登录
    @GetMapping("/login")
    public String login(AdministratorLoginInDTO administratorLoginInDTO){
        return null;
    }

    //获取
    public AdministratorGetProfileOutDTO getProfile(Integer administratorId){
        return null;
    }

    //更新
    @PostMapping("/updateProfile")
    public void updateProdfile(@RequestBody AdministratorUpdateProfileInDTO AdministratorUpdateProfileInDTO){
    }

    //拿到重置密码
    @GetMapping("/getPwdReseCode")
    public String getPwdReseCode(@RequestParam String email){
        return null;
    }

    //重置密码
    @PostMapping("/restPwd")
    public void restPwd(@RequestBody AdministratorRestPwdInDTO administratorRestPwdInDTO){}

   //分页
    @GetMapping("/getList")
   public PageOutDTO<AdministratorListOutDTO> getList(@RequestParam Integer pageNum){
        return  null;
   }

   //回显
    @GetMapping("/getById")
    public AdministratorShowOutDTO getById(@RequestParam Integer administratorId){
        return null;
    }

    //创建
    @PostMapping("/crate")
    public Integer crate(@RequestBody AdministratorCrateInDTO administratorCrateInDTO){
        return null;
    }

    @PostMapping("/update")
    public void update(@RequestBody AdministratorUpdateDTO administratorUpdateDTO){
    }
}

