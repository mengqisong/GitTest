package io.mqs.jcartstoreback.service;

import com.github.pagehelper.Page;
import io.mqs.jcartstoreback.po.Return;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnService {
    Integer create(Return aReturn);

    Page<Return> getPageByCustomerId(Integer customerId, Integer pageNum);

    Return getById(Integer returnId);
}
