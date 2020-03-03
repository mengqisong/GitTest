package io.mqs.jcartadministrationback.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import io.mqs.jcartadministrationback.constant.ClientExceptionConstant;
import io.mqs.jcartadministrationback.dto.in.*;
import io.mqs.jcartadministrationback.dto.out.*;
import io.mqs.jcartadministrationback.enumeration.AdministratorStatus;
import io.mqs.jcartadministrationback.exception.ClientException;
import io.mqs.jcartadministrationback.po.Administrator;
import io.mqs.jcartadministrationback.service.AdministratorService;
import io.mqs.jcartadministrationback.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/administrator")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @Autowired
    private JWTUtil jwtUtil;

    //登录
    @GetMapping("/login")
    public AdministratorLoginOutDTO login(AdministratorLoginInDTO administratorLoginInDTO) throws ClientException {
        Administrator administrator = administratorService.getByUsername(administratorLoginInDTO.getUsername());
        if (administrator == null){
            throw new ClientException(ClientExceptionConstant.ADMINISTRATOR_USERNAME_NOT_EXIST_ERRCODE, ClientExceptionConstant.ADMINISTRATOR_USERNAME_NOT_EXIST_ERRMSG);
        }
        String encPwdDB = administrator.getEncryptedPassword();
        BCrypt.Result result = BCrypt.verifyer().verify(administratorLoginInDTO.getPassword().toCharArray(), encPwdDB);

        if (result.verified) {
            AdministratorLoginOutDTO administratorLoginOutDTO = jwtUtil.issueToken(administrator);
            return administratorLoginOutDTO;
        }else {
            throw new ClientException(ClientExceptionConstant.ADNINISTRATOR_PASSWORD_INVALID_ERRCODE, ClientExceptionConstant.ADNINISTRATOR_PASSWORD_INVALID_ERRMSG);
        }
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
        Administrator administrator = new Administrator();
        administrator.setUsername(administratorCrateInDTO.getUsername());
        administrator.setRealName(administratorCrateInDTO.getRealName());
        administrator.setEmail(administratorCrateInDTO.getEmail());
        administrator.setAvatarUrl(administratorCrateInDTO.getAvatarUrl());
        administrator.setStatus((byte) AdministratorStatus.Enable.ordinal());
        administrator.setCreateTime(new Date());

        String bcryptHashString = BCrypt.withDefaults().hashToString(12, administratorCrateInDTO.getPassword().toCharArray());
        administrator.setEncryptedPassword(bcryptHashString);

        return administratorService.create(administrator);
    }

    @PostMapping("/update")
    public void update(@RequestBody AdministratorUpdateDTO administratorUpdateDTO){
    }
}

