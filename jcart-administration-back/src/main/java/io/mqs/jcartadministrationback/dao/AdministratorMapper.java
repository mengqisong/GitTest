package io.mqs.jcartadministrationback.dao;

import com.github.pagehelper.Page;
import io.mqs.jcartadministrationback.po.Administrator;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdministratorMapper {
    int deleteByPrimaryKey(Integer administratorId);

    int insert(Administrator record);

    int insertSelective(Administrator record);

    Administrator selectByPrimaryKey(Integer administratorId);

    int updateByPrimaryKeySelective(Administrator record);

    int updateByPrimaryKey(Administrator record);

    Administrator selectByUsername(String username);


    //new
    Administrator getByUsername(String username);

    void batchDelete(@Param("administratorIds") List<Integer> administratorIds);

    Page<Administrator> selectList();

    Administrator getByEmail(String email);
}