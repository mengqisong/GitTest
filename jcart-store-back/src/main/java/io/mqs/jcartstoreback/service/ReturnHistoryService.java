package io.mqs.jcartstoreback.service;

import io.mqs.jcartstoreback.po.ReturnHistory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReturnHistoryService {
    List<ReturnHistory> getByReturnId(Integer returnId);
}
