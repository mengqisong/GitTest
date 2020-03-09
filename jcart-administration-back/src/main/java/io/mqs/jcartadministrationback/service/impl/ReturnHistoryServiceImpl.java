package io.mqs.jcartadministrationback.service.impl;

import io.mqs.jcartadministrationback.dao.ReturnHistoryMapper;
import io.mqs.jcartadministrationback.po.Return;
import io.mqs.jcartadministrationback.po.ReturnHistory;
import io.mqs.jcartadministrationback.service.ReturnHistoryService;
import io.mqs.jcartadministrationback.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ReturnHistoryServiceImpl implements ReturnHistoryService {
    @Autowired
    ReturnHistoryMapper returnHistoryMapper;

    @Autowired
    ReturnService returnService;

    @Override
    public List<ReturnHistory> getListByReturnId(Integer returnId) {
        return returnHistoryMapper.selectListByReturnId(returnId);
    }

    @Override
    @Transactional
    public Long create(ReturnHistory returnHistory) {
        returnHistoryMapper.insertSelective(returnHistory);
        Long returnHistoryId = returnHistory.getReturnHistoryId();

        Return aReturn = new Return();
        aReturn.setReturnId(returnHistory.getReturnId());
        aReturn.setUpdateTime(new Date());
        returnService.update(aReturn);

        return returnHistoryId;
    }
}
