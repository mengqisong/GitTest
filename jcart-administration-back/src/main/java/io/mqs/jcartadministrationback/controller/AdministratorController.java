package io.mqs.jcartadministrationback.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.github.pagehelper.Page;
import io.mqs.jcartadministrationback.constant.ClientExceptionConstant;
import io.mqs.jcartadministrationback.dto.in.*;
import io.mqs.jcartadministrationback.dto.out.*;
import io.mqs.jcartadministrationback.enumeration.AdministratorStatus;
import io.mqs.jcartadministrationback.exception.ClientException;
import io.mqs.jcartadministrationback.po.Administrator;
import io.mqs.jcartadministrationback.service.AdministratorService;
import io.mqs.jcartadministrationback.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.DatatypeConverter;
import java.security.SecureRandom;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/administrator")
@CrossOrigin
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    SecureRandom secureRandom;

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;

    private Map<String, String> emailPwdResetCodeMap = new HashMap<>();

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

    @GetMapping("/getProfile")
    public AdministratorGetProfileOutDTO getProfile(@RequestAttribute Integer administratorId){
        Administrator administrator = administratorService.getProfile(administratorId);

        AdministratorGetProfileOutDTO administratorGetProfileOutDTO = new AdministratorGetProfileOutDTO();
        administratorGetProfileOutDTO.setAdministratorId(administrator.getAdministratorId());
        administratorGetProfileOutDTO.setAvatarUrl(administrator.getAvatarUrl());
        administratorGetProfileOutDTO.setEmail(administrator.getEmail());
        administratorGetProfileOutDTO.setRealname(administrator.getRealName());
        administratorGetProfileOutDTO.setUsername(administrator.getUsername());
        administratorGetProfileOutDTO.setCreateTimestamp(administrator.getCreateTime().getTime());
        return administratorGetProfileOutDTO;
    }

    @PostMapping("/updateProfile")
    public void updateProdfile(@RequestBody AdministratorUpdateProfileInDTO AdministratorUpdateProfileInDTO,
                               @RequestAttribute Integer administratorId){
        Administrator administrator = new Administrator();
        administrator.setAdministratorId(administratorId);
        administrator.setAvatarUrl(AdministratorUpdateProfileInDTO.getAvatarUrl());
        administrator.setEmail(AdministratorUpdateProfileInDTO.getEmail());
        administrator.setRealName(AdministratorUpdateProfileInDTO.getRealName());

        administratorService.update(administrator);
    }

    @PostMapping("/changepwd")
    public void changepwd(@RequestBody AdministratorChangePwdInDTO administratorChangePwdInDTO,
                          @RequestAttribute Integer administratorId){}

    @GetMapping("/getPwdReseCode")
    public String getPwdReseCode(@RequestParam String email){
        return null;
    }

    @PostMapping("/restPwd")
    public void restPwd(@RequestBody AdministratorRestPwdInDTO administratorRestPwdInDTO){}

    @GetMapping("/getList")
   public PageOutDTO<AdministratorListOutDTO> getList(@RequestParam(required = false, defaultValue = "1") Integer pageNum){
        Page<Administrator> page = administratorService.getList(pageNum);
        List<AdministratorListOutDTO> administratorListOutDTOS = page.stream().map(administrator -> {
            AdministratorListOutDTO administratorListOutDTO = new AdministratorListOutDTO();
            administratorListOutDTO.setAdministratorId(administrator.getAdministratorId());
            administratorListOutDTO.setUsername(administrator.getUsername());
            administratorListOutDTO.setRealName(administrator.getRealName());
            administratorListOutDTO.setStatus(administrator.getStatus());
            administratorListOutDTO.setCreateTimestamp(administrator.getCreateTime().getTime());
            return administratorListOutDTO;
        }).collect(Collectors.toList());

        PageOutDTO<AdministratorListOutDTO> pageOutDTO = new PageOutDTO<>();
        pageOutDTO.setTotal(page.getTotal());
        pageOutDTO.setPageSize(page.getPageSize());
        pageOutDTO.setPageNum(page.getPageNum());
        pageOutDTO.setList(administratorListOutDTOS);


        return pageOutDTO;
    }

    @GetMapping("/getById")
    public AdministratorShowOutDTO getById(@RequestParam Integer administratorId){
        Administrator administrator = administratorService.getById(administratorId);

        AdministratorShowOutDTO administratorShowOutDTO = new AdministratorShowOutDTO();
        administratorShowOutDTO.setAdministratorId(administrator.getAdministratorId());
        administratorShowOutDTO.setUsername(administrator.getUsername());
        administratorShowOutDTO.setRealName(administrator.getRealName());
        administratorShowOutDTO.setEmail(administrator.getEmail());
        administratorShowOutDTO.setAvatarUrl(administrator.getAvatarUrl());
        administratorShowOutDTO.setStatus(administrator.getStatus());

        return  administratorShowOutDTO;
    }

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
    public void update(@RequestBody AdministratorUpdateDTO administratorUpdateInDTO){
        Administrator administrator = new Administrator();
        administrator.setUsername(administratorUpdateInDTO.getUsername());
        administrator.setAdministratorId(administratorUpdateInDTO.getAdministratorId());
        administrator.setRealName(administratorUpdateInDTO.getRealName());
        administrator.setEmail(administratorUpdateInDTO.getEmail());
        administrator.setAvatarUrl(administratorUpdateInDTO.getAvatarUrl());
        administrator.setStatus(administratorUpdateInDTO.getStatus());
        String password = administratorUpdateInDTO.getPassword();

        if (password != null && !password.isEmpty()){
            String bcryptHashString = BCrypt.withDefaults().hashToString(12, password.toCharArray());
            administrator.setEncryptedPassword(bcryptHashString);
        }

        administratorService.update(administrator);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Integer adminstratorId){
        administratorService.delete(adminstratorId);
    }

    @PostMapping("/batchDelete")
    public void batchDelete(@RequestBody List<Integer> administratorIds){
        administratorService.batchDelete(administratorIds);
    }

    @GetMapping("/getPwdResetCode")
    public void getPwdResetCode(@RequestParam String email) throws ClientException {
        Administrator administrator = administratorService.getByEmail(email);
        if (administrator == null){
            throw new ClientException(ClientExceptionConstant.ADMINISTRATOR_EMAIL_NOT_EXIST_ERRCODE, ClientExceptionConstant.ADMINISTRATOR_EMAIL_NOT_EXIST_ERRMSG);
        }

        byte[] bytes = secureRandom.generateSeed(3);
        String hex = DatatypeConverter.printHexBinary(bytes);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(fromEmail);
        mailMessage.setTo(email);
        mailMessage.setSubject("密码重置");
        mailMessage.setText(hex);

        emailPwdResetCodeMap.put(email,hex);
    }
}

