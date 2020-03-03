package io.mqs.jcartadministrationback.service;

import io.mqs.jcartadministrationback.po.Administrator;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorService {

    Administrator getByUsername(String username);

    Integer create(Administrator administrator);

    Administrator getProfile(Integer administratorId);
}
