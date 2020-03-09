package io.mqs.jcartadministrationback.service;

import io.mqs.jcartadministrationback.po.ReturnHistory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReturnHistoryService {
    List<ReturnHistory> getListByReturnId(Integer returnId);

    Long create(ReturnHistory returnHistory);
}
