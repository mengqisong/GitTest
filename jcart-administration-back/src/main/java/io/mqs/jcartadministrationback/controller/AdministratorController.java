package io.mqs.jcartadministrationback.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import io.mqs.jcartadministrationback.constant.ClientExceptionConstant;
import io.mqs.jcartadministrationback.dto.in.*;
import io.mqs.jcartadministrationback.dto.out.*;
import io.mqs.jcartadministrationback.exception.ClientException;
import io.mqs.jcartadministrationback.po.Administrator;
import io.mqs.jcartadministrationback.service.AdministratorService;
import io.mqs.jcartadministrationback.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/getProfile")
    public AdministratorGetProfileOutDTO getProfile(Integer administratorId){
        Administrator administrator = administratorService.getById(administratorId);
        AdministratorGetProfileOutDTO administratorGetProfileOutDTO = new AdministratorGetProfileOutDTO();
        administratorGetProfileOutDTO.setAdministratorId(administrator.getAdministratorId());
        administratorGetProfileOutDTO.setUsername(administrator.getUsername());
        administratorGetProfileOutDTO.setEmail(administrator.getEmail());
        administratorGetProfileOutDTO.setAvatarUrl(administrator.getAvatarUrl());

        return administratorGetProfileOutDTO;
    }

    //更新
    @PostMapping("/updateProfile")
    public void updateProdfile(@RequestBody AdministratorUpdateProfileInDTO administratorUpdateProfileInDTO,
                               @RequestAttribute Integer administratorId){
        Administrator administrator = new Administrator();
        administrator.setAdministratorId(administratorId);
        administrator.setEmail(administratorUpdateProfileInDTO.getEmail());
        administrator.setAvatarUrl(administratorUpdateProfileInDTO.getAvatarUrl());
        administratorService.update(administrator);

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

