package io.mqs.jcartadministrationback.service;

import com.github.pagehelper.Page;
import io.mqs.jcartadministrationback.dto.out.AdministratorShowOutDTO;
import io.mqs.jcartadministrationback.po.Administrator;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdministratorService {

    Administrator getByUsername(String username);

    Integer create(Administrator administrator);

    Administrator getProfile(Integer administratorId);

    void update(Administrator administrator);

    Administrator getById(Integer administratorId);

    void delete(Integer adminstratorId);

    void batchDelete(List<Integer> administratorIds);

    Page<Administrator> getList(Integer pageNum);

    Administrator getByEmail(String email);
}
