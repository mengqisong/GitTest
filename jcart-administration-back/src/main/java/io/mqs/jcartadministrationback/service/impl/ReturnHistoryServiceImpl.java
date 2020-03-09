package io.mqs.jcartadministrationback.service.impl;

import io.mqs.jcartadministrationback.dao.ReturnHistoryMapper;
import io.mqs.jcartadministrationback.po.ReturnHistory;
import io.mqs.jcartadministrationback.service.ReturnHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReturnHistoryServiceImpl implements ReturnHistoryService {
    @Autowired
    ReturnHistoryMapper returnHistoryMapper;

    @Override
    public List<ReturnHistory> getListByReturnId(Integer returnId) {
        return returnHistoryMapper.selectListByReturnId(returnId);
    }
}
