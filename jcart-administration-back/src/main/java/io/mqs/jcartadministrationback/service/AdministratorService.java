package io.mqs.jcartadministrationback.service;

import io.mqs.jcartadministrationback.po.Administrator;

public interface AdministratorService {

    Administrator getById(Integer administratorId);

    Administrator getByUsername(String username);

    void update(Administrator administrator);

}
