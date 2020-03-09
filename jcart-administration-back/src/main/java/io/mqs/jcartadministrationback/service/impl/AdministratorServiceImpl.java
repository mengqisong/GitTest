package io.mqs.jcartadministrationback.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.mqs.jcartadministrationback.dao.AdministratorMapper;
import io.mqs.jcartadministrationback.dto.out.AdministratorGetProfileOutDTO;
import io.mqs.jcartadministrationback.po.Administrator;
import io.mqs.jcartadministrationback.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorServiceImpl implements AdministratorService {
    @Autowired
    private AdministratorMapper administratorMapper;

    @Override
    public Administrator getByUsername(String username) {
        return administratorMapper.getByUsername(username);
    }

    @Override
    public Integer create(Administrator administrator) {
        administratorMapper.insertSelective(administrator);
        return administrator.getAdministratorId();
    }

    @Override
    public Administrator getProfile(Integer administratorId) {
        return administratorMapper.selectByPrimaryKey(administratorId);
    }

    @Override
    public void update(Administrator administrator) {
        administratorMapper.updateByPrimaryKeySelective(administrator);
    }

    @Override
    public Administrator getById(Integer administratorId) {
        return administratorMapper.selectByPrimaryKey(administratorId);
    }

    @Override
    public void delete(Integer adminstratorId) {
        administratorMapper.deleteByPrimaryKey(adminstratorId);
    }

    @Override
    public void batchDelete(List<Integer> administratorIds) {
        administratorMapper.batchDelete(administratorIds);
    }

    @Override
    public Page<Administrator> getList(Integer pageNum) {
        PageHelper.startPage(pageNum,10);

        return administratorMapper.selectList();
    }

    @Override
    public Administrator getByEmail(String email) {
        return administratorMapper.getByEmail(email);
    }


}
