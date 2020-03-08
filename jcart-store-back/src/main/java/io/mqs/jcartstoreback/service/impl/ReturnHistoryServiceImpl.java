package io.mqs.jcartstoreback.service.impl;

import io.mqs.jcartstoreback.dao.ReturnHistoryMapper;
import io.mqs.jcartstoreback.po.ReturnHistory;
import io.mqs.jcartstoreback.service.ReturnHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReturnHistoryServiceImpl implements ReturnHistoryService {
    @Autowired
    ReturnHistoryMapper returnHistoryMapper;

    @Override
    public List<ReturnHistory> getByReturnId(Integer returnId) {
        return returnHistoryMapper.selectByReturnId(returnId);
    }
}
