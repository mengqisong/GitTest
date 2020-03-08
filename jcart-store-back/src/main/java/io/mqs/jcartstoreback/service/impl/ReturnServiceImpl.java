package io.mqs.jcartstoreback.service.impl;

import io.mqs.jcartstoreback.dao.ReturnMapper;
import io.mqs.jcartstoreback.po.Return;
import io.mqs.jcartstoreback.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReturnServiceImpl implements ReturnService {
    @Autowired
    ReturnMapper returnMapper;

    @Override
    public Integer create(Return aReturn) {
        returnMapper.insertSelective(aReturn);
        Integer returnId = aReturn.getReturnId();
        return returnId;
    }
}
