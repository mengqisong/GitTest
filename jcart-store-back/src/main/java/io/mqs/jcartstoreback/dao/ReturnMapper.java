package io.mqs.jcartstoreback.dao;

import com.github.pagehelper.Page;
import io.mqs.jcartstoreback.po.Return;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnMapper {
    int deleteByPrimaryKey(Integer returnId);

    int insert(Return record);

    int insertSelective(Return record);

    Return selectByPrimaryKey(Integer returnId);

    int updateByPrimaryKeySelective(Return record);

    int updateByPrimaryKey(Return record);

    Page<Return> selectPageByCustomerId(@Param("customerId") Integer customerId);
}